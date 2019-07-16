package com.panguaxe.sky.SDK.wechatpay.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ClassName: PayBankRequest 
 * @Description: TODO --- 获取RSA公钥---请求
 * @author 作者：Mike
 * @date 2018年10月31日
 */
public class GetpublickeyRequest {

	/** 商户号 */
	@XStreamAlias("mch_id")
	private String mch_id;
	/** 随机字符串 */
	@XStreamAlias("nonce_str")
	private String nonce_str;
	/** 签名 */
	@XStreamAlias("sign")
	private String sign;
	/** 签名类型 */
	@XStreamAlias("sign_type")
	private String sign_type;

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
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

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

}
