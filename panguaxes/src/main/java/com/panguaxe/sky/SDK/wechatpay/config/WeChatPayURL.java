package com.panguaxe.sky.SDK.wechatpay.config;

/**
 * @ClassName WeChatPayURL
 * @Description TODO :
 * @Author ：Panguaxe
 * @Date 2019/7/16 21:16
 * @Version V1.0
 */
public class WeChatPayURL {

    private static final String WECHATPAY_SERVERURL ="https://api.mch.weixin.qq.com/";

    public static enum WECHATPAY_REQ_URL {
        /**微信支付提现---企业付款*/
        WECHATPAY_TRANSFERS_URL("mmpaymkttransfers/promotion/transfers"),
        /**微信---查询企业付款*/
        WECHATPAY_GETTRANSFERINFO_URL("mmpaymkttransfers/gettransferinfo"),
        /**微信---企业付款到银行卡*/
        WECHATPAY_PAY_BANK_URL("mmpaysptrans/pay_bank"),
        /**获取公钥*/
        WECHATPAY_GETPUBLICKEY_URL("risk/getpublickey"),
        /**统一下单*/
        WECHATPAY_UNIFIEDORDER_URL("pay/unifiedorder"),
        /**查询订单（统一下单）*/
        WECHATPAY_ORDERQUERY_URL("pay/orderquery");

        private String reqUrl;

        public String getReqUrl() {
            return reqUrl;
        }

        public void setReqUrl(String reqUrl) {
            this.reqUrl = reqUrl;
        }

         WECHATPAY_REQ_URL(String reqUrl) {
            this.reqUrl = WECHATPAY_SERVERURL + reqUrl;
        }

    }
}
