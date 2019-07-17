package com.panguaxe.sky.api;

import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.land.service.IAccountService;
import com.panguaxe.sky.land.service.IVerifiCodeService;
import com.panguaxe.sky.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @Title ApiAccountLoginController
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 16:22
 **/
@RestController
@RequestMapping("/api/")
public class ApiAccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiAccountController.class);

    @Autowired
    private IAccountService accountService;
    @Autowired
    private IVerifiCodeService verifiCodeService;
    /**
     * @MethodName:  accountLogin
     * @Param:       [request, userName, password]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:33
     * @Description: TODO               账号登录【账号、密码】
     */
    @PostMapping("/accountLogin.axe")
    public APIResult accountLogin(HttpServletRequest request, String userName, String password){
        APIResult result = new APIResult();
        if (ObjectUtils.isEmpty(userName) || ObjectUtils.isEmpty(password)){
            result.setError("用户名或密码不能为空!");
        }
        try {
            result = accountService.accountLogin(request,userName,password);
        }catch (Exception e){
            LOGGER.info("👻,请联系管理员[网络异常18300665808]!{}",e.getMessage());
            result.setError(GlobalEnums.API_NETWORK_ANOMALY.getMessage());
        }
        return result;
    }

    /**
     * @MethodName:  accountLogon
     * @Param:       [telephone, smsCode，gender]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/12 22:01
     * @Description: TODO               账户注册【手机号、验证码注册】
     */
    @PostMapping("accountLogon.axe")
    public APIResult accountLogon(String telephone,String smsCode,Integer gender){
        APIResult result = new APIResult();
        if (ObjectUtils.isEmpty(smsCode)){
            return result.setError("请输入验证码……");
        }
       try {
            result = accountService.accountLogon(telephone,smsCode,gender);
        }catch (Exception e){
            result.setError("注册异常[" + GlobalEnums.API_NETWORK_ANOMALY.getMessage() + "]");
            LOGGER.info("注册异常{}",e.getMessage());
        }
        return result;
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              获取验证码
     * @Date: 2019年07月13日 11:33
     * @param telephone
     * @param smsSort
     * @return com.panguaxe.sky.common.APIResult
     **/
    @PostMapping("generateSmsCode.axe")
    public APIResult generateSmsCode(String telephone, Integer smsSort){
        APIResult result = new APIResult();
        if (ObjectUtils.isEmpty(telephone)){
            return result.setError("请输入手机号");
        }
        try {
            result = verifiCodeService.generateSmsCode(telephone,smsSort);
        }catch (Exception e){
            result.setError("获取验证码[" + GlobalEnums.API_NETWORK_ANOMALY.getMessage() + "]");
            LOGGER.info("获取验证码{}",e.getMessage());
        }
        return result;
    }
}
