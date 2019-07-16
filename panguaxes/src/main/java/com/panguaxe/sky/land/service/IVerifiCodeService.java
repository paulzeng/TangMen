package com.panguaxe.sky.land.service;

import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.land.model.VerifiCode;

public interface IVerifiCodeService extends IBaseService<VerifiCode>{

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          校验验证码
     * @Date: 2019年07月13日 10:54
     * @param telephone     手机号
     * @param smsCode       验证码
     * @param smsSort       短信分类: 1 注册; 2 验证码登陆；……
     * @return VerifiCode
     **/
    VerifiCode checkVerifiCode(String telephone,String smsCode,Integer smsSort);
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          获取验证码
     * @Date: 2019年07月13日 11:02
     * @param telephone     手机号
     * @param smsSort       短信分类: 1 注册; 2 验证码登陆；……
     * @return APIResult
     **/
    APIResult generateSmsCode(String telephone, Integer smsSort);

}
