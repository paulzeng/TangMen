package com.panguaxe.sky.SDK.wechatpay.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ClassName: TransfersRequest
 * 
 * @Description: TODO --- 微信---企业付款---请求
 * @author 作者：Mike
 * @date 2018年10月26日
 */
public class TransfersRequest {

	/** 商户账号appid */
	@XStreamAlias("mch_appid")
	private String mch_appid;

	/** 商户号 */
	@XStreamAlias("mchid")
	private String mchid;

	/** 随机字符串---随机字符串，不长于32位 */
	@XStreamAlias("nonce_str")
	private String nonce_str;

	/** 签名---不长于32位 */
	@XStreamAlias("sign")
	private String sign;

	/** 商户订单号---不长于32位---商户订单号，需保持唯一性(只能是字母或者数字，不能包含有其他字符) */
	@XStreamAlias("partner_trade_no")
	private String partner_trade_no;

	/** 用户openid---商户appid下，某用户的openid---64位 */
	@XStreamAlias("openid")
	private String openid;

	/** 校验用户姓名选项---16位---NO_CHECK：不校验真实姓名 ;FORCE_CHECK：强校验真实姓名 */
	@XStreamAlias("check_name")
	private String check_name;

	/** 收款用户姓名---64位---收款用户真实姓名。 如果check_name设置为FORCE_CHECK，则必填用户真实姓名 */
	@XStreamAlias("re_user_name")
	private String re_user_name;

	/** 金额---企业付款金额，单位为分 */
	@XStreamAlias("amount")
	private Integer amount;

	/** 企业付款备注---企业付款备注，必填---100位 */
	@XStreamAlias("desc")
	private String desc;

	/** Ip地址---100位---该IP同在商户平台设置的IP白名单中的IP没有关联，该IP可传用户端或者服务端的IP。 */
	@XStreamAlias("spbill_create_ip")
	private String spbill_create_ip;

	public String getMch_appid() {
		return mch_appid;
	}

	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCheck_name() {
		return check_name;
	}

	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	public String getRe_user_name() {
		return re_user_name;
	}

	public void setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

}
