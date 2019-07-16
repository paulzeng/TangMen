package com.panguaxe.sky.land.service;

import com.panguaxe.sky.common.APIResult;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.SortedMap;
/**
 * @Author 作者 : Panguaxe
 * @Description //TODO          微信支付
 * @Date: 2019年07月12日 13:31
 **/
public interface WeChatDefrayService {

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO      微信支付--- H5支付
     * @Date: 2019年07月12日 13:29
     * @param req
     * @param money         金额
     * @param openId        微信Openid
     * @param orderNo       订单号：业务表主键（发红包、会员升级等主键ID。。。）
     * @param bussType      业务类型：（red-发红包   vip-会员升级，后期可加）此字段必传
     * @param payType       支付方式：H5（Wap）、IOS、Android
     **/
    SortedMap<String, Object> weChatDefray(HttpServletRequest req,int money,String openId,String orderNo,String bussType,String payType);
    /**
     * @Author 作者 : Ascetic Monk
     * @Description //TODO      微信支付--- 统一下单
     * @Date: 2019年07月12日 13:33
     * @param body
     * @param total_fee
     * @param openId
     * @param bussType
     * @param bussId
     **/
    APIResult weChatUniformOrder(String body,BigDecimal total_fee,String openId,String bussType,String bussId);
}
