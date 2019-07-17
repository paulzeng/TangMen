package com.panguaxe.sky.resolver;

import com.panguaxe.sky.annotation.Authorization;
import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.land.model.Account;
import com.panguaxe.sky.land.service.IAccountService;
import com.panguaxe.sky.utils.JWTUtil;
import com.panguaxe.sky.utils.ObjectUtils;
import com.panguaxe.sky.utils.http.RequestUtil;
import com.panguaxe.sky.utils.json.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
/**
 * @Author 作者 : Panguaxe
 * @Description //TODO              基于jwt的登录拦截器
 * @Date: 2019年07月12日 17:06
 **/
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {



    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationInterceptor.class);
    @Autowired
    private IAccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        APIResult result = new APIResult();
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //防止恶意添加用户参数
        request.setAttribute(GlobalConst.HTTP_CURRENT_USER_PARAM_KEY, null);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //是否需要认证
        boolean isAuth = isAuthorization(method);
        if (!isAuth){
            return true;
        }
        // 从header中得到token
        String token = request.getHeader(GlobalConst.HTTP_JWT_PARAM_KEY);
        result.setData(token);
        String mobile = JWTUtil.getMobile(token);
        if (StringUtils.isBlank(mobile)) {
            writeResponse(request, response, result.setError("认证失败!"));
            return false;
        }
        Account account = accountService.findAccountByTelOrUsername(mobile, mobile);
        if (ObjectUtils.isEmpty(account)){
            writeResponse(request, response,result.setError("数据异常,认证失败"));
            return false;
        }
        result = JWTUtil.tokenVerify(token, mobile, account.getPassword());

        if (!result.isSuccess()){
            writeResponse(request, response, result);
        } else{
            request.setAttribute(GlobalConst.HTTP_CURRENT_USER_PARAM_KEY, account.getId());
        }
        return result.isSuccess();
    }

    /**
     * @Description: 是否需要认证
     * @Param: [method]
     * @return: boolean true:需要;false:不需要
     * @Author: why
     * @Date: 2019-03-08 16:45
     */
    private boolean isAuthorization(Method method) {
        if (method.isAnnotationPresent(Authorization.class)){
            return method.getAnnotation(Authorization.class).auth();
        }else{
            return method.getDeclaringClass().isAnnotationPresent(Authorization.class) && method.getDeclaringClass().getAnnotation(Authorization.class).auth();
        }
    }

    private void writeResponse(HttpServletRequest request, HttpServletResponse response, APIResult result) {
        JsonUtil.writeResponse(response, result);
        LOGGER.info("认证失败,请求地址:{},头信息:{},参数:{}", request.getRequestURI(), result.getData(), JsonUtil.ObjToString(RequestUtil.getParameterMap(request)));
    }
}
