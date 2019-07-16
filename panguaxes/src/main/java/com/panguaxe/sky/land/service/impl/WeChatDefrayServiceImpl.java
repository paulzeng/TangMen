package com.panguaxe.sky.land.service.impl;

import com.panguaxe.sky.SDK.wechatpay.api.WeChatPayApi;
import com.panguaxe.sky.SDK.wechatpay.req.PayUnifiedorderRequest;
import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.common.WeChatDefrayReqParams;
import com.panguaxe.sky.common.ResultEntity;
import com.panguaxe.sky.config.RedBagConfig;
import com.panguaxe.sky.config.WeChatPayConfig;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.land.service.WeChatDefrayService;
import com.panguaxe.sky.utils.ObjectUtils;
import com.panguaxe.sky.utils.WeChatDefrayUtils;
import net.sf.json.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Title WeChatH5PayServiceImpl
 * @Description // TODO
 * @Author 作者：Mike Cium
 * @Version: 1.0
 * @Date 2019/4/9 13:54
 **/
@Service
public class WeChatDefrayServiceImpl implements WeChatDefrayService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatDefrayServiceImpl.class);

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO      微信支付--- H5支付
     * @Date: 2019年07月12日 13:29
     * @param req
     * @param money         金额
     * @param openId        微信Openid
     * @param orderNo       订单号：业务表主键（发红包、会员升级等主键ID。。。）
     * @param bussType      业务类型：（RED-发红包   VIP-会员升级，后期可加）此字段必传
     * @param payType       支付方式：H5（Wap）、IOS、Android
     **/
    @Override
    public SortedMap<String, Object> weChatDefray(HttpServletRequest req, int money, String openId, String orderNo, String bussType, String payType) {
        SortedMap<String, Object> resultMap = new TreeMap<String, Object>();
        Map<String, String> dataMap = new HashMap<>();
        WeChatDefrayReqParams wcdrp = new WeChatDefrayReqParams();
        wcdrp.setOut_trade_no(orderNo);
        wcdrp.setTotal_fee(money);
        wcdrp.setBody(bussType);
        if (RedBagConfig.REDBAG_PAYTYPE_WAP.equals(payType)) {
            wcdrp.setTrade_type("MWEB");
            JSONObject obj = new JSONObject();
            obj.put("type", payType);
            if (RedBagConfig.REDBAG_PAYTYPE_IOS.equals(payType) || RedBagConfig.REDBAG_PAYTYPE_ANDROID.equals(payType)) {
                obj.put("app_name", "");
                if (RedBagConfig.REDBAG_PAYTYPE_IOS.equals(payType)) {
                    obj.put("bundle_id", "");
                } else {
                    obj.put("package_name", "");
                }
                wcdrp.setTrade_type("APP");
                wcdrp.setSpbill_create_ip(ObjectUtils.getHostIp());
            } else {
                obj.put("wap_url", "");
                obj.put("wap_name", "");
                wcdrp.setSpbill_create_ip(ObjectUtils.getIpAddr(req));
            }
            JSONObject sceneInfo = new JSONObject();
            sceneInfo.put("h5_info", obj.toString());

            wcdrp.setScene_info(sceneInfo.toString());
        } else {
            wcdrp.setTrade_type("JSAPI");
            wcdrp.setSpbill_create_ip(ObjectUtils.getHostIp());
            wcdrp.setOpenId(openId);
        }
        SortedMap<String, Object> reqParams = WeChatDefrayUtils.buildParamMap(wcdrp);
        wcdrp.setSign(WeChatDefrayUtils.getSign(reqParams,WeChatPayConfig.WECHAT_MCH_KEY));
        // 将请求参数对象转换成xml
        String reqXml = WeChatDefrayUtils.sendDataToXml(wcdrp);
        LOGGER.info("微信支付参数：{}",reqXml);
        try {
            CloseableHttpResponse response = WeChatDefrayUtils.Post(WeChatPayConfig.WECHAT_PAY_REQURL,reqXml,false);
            try {
                dataMap = WeChatDefrayUtils.parseXml(response.getEntity().getContent());
                LOGGER.info("微信支付返回参数：{}",dataMap);
                EntityUtils.consume(response.getEntity());
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String return_code = dataMap.get("return_code");
        String result_code = dataMap.get("result_code");
        if (WeChatPayConfig.RETURN_SUCCESS.equals(return_code) && WeChatPayConfig.RETURN_SUCCESS.equals(result_code)) {
            // 当前时间戳
            String timeStamp = WeChatDefrayUtils.getTimeStamp();
            resultMap.put("timeStamp", timeStamp);
            String prepayId = "prepay_id=" + dataMap.get("prepay_id");
            // 不长于32位的随机字符串
            String nonceStr = ObjectUtils.getRandomStr(20);
            resultMap.put("nonceStr", nonceStr);
            //交易类型：JSAPI、MWEB
            String tradeType = dataMap.get("trade_type");
            //公众号支付
            if (RedBagConfig.REDBAG_PAYTYPE_JSAPI.equals(tradeType)) {
                // 公众号appid
                resultMap.put("appId", WeChatPayConfig.WECHAT_MCH_APPID);
                // 预支付交易会话标识
                resultMap.put("package", prepayId);
                // 微信签名方式
                resultMap.put("signType", "MD5");
                // 微信签名
                resultMap.put("paySign", WeChatDefrayUtils.getSign(resultMap, WeChatPayConfig.WECHAT_MCH_KEY));
            } else if ("APP".equals(tradeType)) {
                // 公众号appid
                resultMap.put("appId", WeChatPayConfig.WECHAT_MCH_APPID);
                // 预支付交易会话标识
                resultMap.put("partnerid", WeChatPayConfig.WECHAT_MCHID);
                // 预支付交易会话标识
                resultMap.put("prepayid", prepayId);
                // 预支付交易会话标识
                resultMap.put("package", "Sign=WXPay");
                resultMap.put("paySign", WeChatDefrayUtils.getSign(resultMap, WeChatPayConfig.WECHAT_MCH_KEY));

                //IOS、Android、WAP进行支付
            } else {
                // app的appid
                resultMap.put("appId", "wxefaa9006deaee096");
                // 预支付交易会话标识
                resultMap.put("package", prepayId);
                // 微信签名方式
                resultMap.put("signType", "MD5");
                // 微信签名
                resultMap.put("paySign", WeChatDefrayUtils.getSign(resultMap, WeChatPayConfig.WECHAT_MCH_KEY));
                //微信回调地址
                String url = "http://webapp.zgzngj.com";
                resultMap.put("mwebUrl", dataMap.get("mweb_url"));
            }
            // 支付结果
            resultMap.put("resultCode", "10000");
        } else {
            // 支付结果
            resultMap.put("resultCode", "10001");
        }
        System.out.println("微信支付下单返回前端信息：" + JSONObject.fromObject(resultMap).toString());
        return resultMap;
    }
    /**
     * @MethodName:  weChatUniformOrder
     * @Param:       [payBody, payAmount, openId, bussType, bussId]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:25
     * @Description: TODO               微信支付统一下单
     */
    @Override
    public APIResult weChatUniformOrder(String payBody, BigDecimal payAmount, String openId, String bussType, String bussId) {
        APIResult j = new APIResult();
        if (ObjectUtils.isEmpty(payBody)) {
            return j.setError("请输入商品描述...");
        }
        if (ObjectUtils.isEmpty(payAmount)) {
            return j.setError("请输入支付金额...");
        }
        PayUnifiedorderRequest req = new PayUnifiedorderRequest();
        // 避免输出科学计数法
        String money = payAmount.stripTrailingZeros().toPlainString();
        req.setBody(payBody);
        req.setTotal_fee(Integer.parseInt(money));
        req.setOut_trade_no(bussId);
        ResultEntity<JSONObject> payUnifiedorder = WeChatPayApi.getInstance().weChatPayUnifiedorder(req);
        // 自然升序map
        SortedMap<String, Object> resultMap = new TreeMap<String, Object>();
        if (GlobalEnums.RESULT_CODE_ENUMS.SUEECEE_CODE.getResultCode().equals(payUnifiedorder.getResultCode())) {
            JSONObject data = payUnifiedorder.getData();
            // 当前时间戳
            String timeStamp = WeChatDefrayUtils.getTimeStamp();
            // 预支付交易会话标识
            resultMap.put("appid", WeChatPayConfig.WECHAT_PAY_UNIFIEDORDER_MCH_APPID);
            // 预支付交易会话标识
            resultMap.put("partnerid", data.getString("mch_id"));
            // 预支付交易会话标识
            resultMap.put("prepayid", data.getString("prepay_id"));
            // 预支付交易会话标识
            resultMap.put("package", "Sign=WXPay");
            // 随机串
            resultMap.put("noncestr", ObjectUtils.getUUID());
            // 时间戳，自1970年以来的秒数
            resultMap.put("timestamp", timeStamp);
            // 微信签名方式
            resultMap.put("sign", WeChatDefrayUtils.getSign(resultMap, WeChatPayConfig.WECHAT_MCH_KEY));
            System.out.println(data);
            j.setData(resultMap);
            j.setMsg("统一下单成功...");
        } else {
            j.setData(payUnifiedorder.getMessage());
            j.setError("统一下单失败...");
        }
        return j;
    }

}
