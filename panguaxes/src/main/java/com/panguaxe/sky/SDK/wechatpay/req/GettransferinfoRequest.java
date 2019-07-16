package com.panguaxe.sky.SDK.wechatpay.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ClassName: GettransferinfoRequest 
 * @Description: TODO --- 微信---查询企业付款---请求
 * @author 作者：Mike
 * @date 2018年10月31日
 */
public class GettransferinfoRequest {

	/** 随机字符串 */
	@XStreamAlias("nonce_str")
	private String nonce_str;
	/** 签名 */
	@XStreamAlias("sign")
	private String sign;
	/** 商户订单号 */
	@XStreamAlias("partner_trade_no")
	private String partner_trade_no;
	/** 商户号 */
	@XStreamAlias("mch_id")
	private String mch_id;
	/** Appid */
	@XStreamAlias("appid")
	private String appid;

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

}
