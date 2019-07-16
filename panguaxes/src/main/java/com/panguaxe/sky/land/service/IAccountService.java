package com.panguaxe.sky.land.service;

import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.land.model.Account;

import javax.servlet.http.HttpServletRequest;

public interface IAccountService extends IBaseService<Account>{

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          根据手机号或者用户名查询用户信息
     * @Date: 2019年07月12日 10:44
     **/
    Account findAccountByTelOrUsername(String userName,String telephone);

    /**
     * @MethodName:  accountLogin
     * @Param:       [request, userName, password]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:43
     * @Description: TODO           登录【账号、密码】
     */
    APIResult accountLogin(HttpServletRequest request, String userName, String password);
    /**
     * @MethodName:  accountLogon
     * @Param:       [telephone, smsCode]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:43
     * @Description: TODO           账号注册【通过手机号】
     */
    APIResult accountLogon(String telephone, String smsCode,Integer gender);
}
