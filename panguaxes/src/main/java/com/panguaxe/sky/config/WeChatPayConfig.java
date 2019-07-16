package com.panguaxe.sky.config;
/**
 * @Author 作者 : Panguaxe
 * @Description //TODO 				微信支付、公众平台相关配置
 * @Date: 2019年07月12日 13:41
 * @Param  * @param null
 * @return
 **/
public class WeChatPayConfig {


	/** API密钥 */
	public static String WECHAT_MCH_KEY = "NVXYI07ZTRYIYXY96FV0XOL50EHAUQFN";
	/** AppSecret是APPID对应的接口密码*/
	public static String WECHAT_MCH_SECRET = "4d28f85ef41b5fcb576ea5dc93816a64";
	/** 商户账号appid   wxbc1e83ab5a11e52c*/
	public static String WECHAT_MCH_APPID = "wx478564310cb6ba0f";
	/** 微信支付分配的商户号 */
	public static String WECHAT_MCHID = "1509889421";
	/** 微信支付公钥 */
	public static String WECHAT_PUBLICKEY = "MIIBCgKCAQEAwPyqspnNPgqmwDDpJLcF7+xBmVMonAwBwToCX/Yu8F9ztAZUVPFIWNkUyClSBj95ME8WBUcC6mhRu9C/OHyuG81oYyufUgdf+BCdc35NP2y8GO/almlhZhymIDUqf97m/Tec/ML5bq+e8GdCxGSJ/CvDQEwuCD977d7ZN01MNkA5ADWQrU0QRHvK4Mranm5W0ltkeJ2j1y0u6CCjVzNe89UiKHDFwj8sR+oDmpAXzs7R2g4a+0hGYS7dzyWhayxCErDrLhBy8JeiZR/jXXiKwA9ZSB00s+Mj4zBrwK06cfHV1NzHe4g9E1SnPS4Eei5Hz3frM5RdDnYX93xbY7qxmwIDAQAB";
	/**企业付款到零钱、银行卡(微信提现)   证书*/
	public static String WECHAT_MCH_CERT = "/etc/pki/weixin/weixin.p12";
	/** 统一下单商户APPID---原生app支付 */
	public static String WECHAT_PAY_UNIFIEDORDER_MCH_APPID =  "wx478564310cb6ba0f";
	/**设备号[WEB]*/
	public static String WECHAT_PAY_DEVICE_INFO =  "WEB";
	/**app支付统一下单通知地址*/
	public static String WECHAT_PAY_UNIFIEDORDER_NOTIFYURL =  "http://web.zgzngj.com/api/notify.rm";
	/**app支付统一下单终端IP*/
	public static String WECHAT_PAY_UNIFIEDORDER_SPBILLIP =  "60.205.190.200";
	/**
	 * 微信支付商户号
	 */
	public static final String MCH_ID = "1509889421";
	/**微信支付请求URL*/
	public static final String WECHAT_PAY_REQURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	/**
	 * 返回成功字符串
	 */
	public static final String RETURN_SUCCESS = "SUCCESS";
	public static final String RETURN_FAIL = "FAIL";

}
