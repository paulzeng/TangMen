package com.panguaxe.sky.resolver;

import com.panguaxe.sky.annotation.CurrentUser;
import com.panguaxe.sky.exception.ServiceException;
import com.panguaxe.sky.land.mapper.AccountMapper;
import com.panguaxe.sky.land.model.Account;
import com.panguaxe.sky.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @program: xyk-master
 * @description: 将含有CurrentUser的参数注入当前用户(需要认证的接口方可使用) AuthorizationInterceptor#isAuthorization(Method)}
 * @author: why
 * @create: 2019-03-01 16:15
 */
@Component
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //如果参数类型是User并且有CurrentUser注解则支持
        if (methodParameter.getParameterType().isAssignableFrom(Account.class) &&
                methodParameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Object accountId = nativeWebRequest.getAttribute(GlobalConst.HTTP_CURRENT_USER_PARAM_KEY, RequestAttributes.SCOPE_REQUEST);
        if (ObjectUtils.isEmpty(accountId)){
            throw new MissingServletRequestPartException(GlobalConst.HTTP_CURRENT_USER_PARAM_KEY);
        }
        Account account = accountMapper.selectByPrimaryKey(accountId);
        if (ObjectUtils.isEmpty(account)){
            throw new ServiceException("用户数据丢失");
        }
        return account;
    }
}
