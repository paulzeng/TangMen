package com.panguaxe.sky.SDK.wechatpay.req;

import com.panguaxe.sky.utils.ObjectUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ClassName: PayOrderqueryRequest 
 * @Description: TODO --- 查询订单(统一下单)
 * @author 作者：Mike
 * @date 2018年11月27日
 */
public class PayOrderqueryRequest {

	/**应用ID---受理商户的APPID（请登录open.weixin.qq.com查看，注意与公众号的APPID不同）*/
	@XStreamAlias("appid")
	private String appid;
	/**商户号---受理商户的商户号*/
	@XStreamAlias("mch_id")
	private String mch_id;
	
	/**
	 * 下边两个二选一    out_trade_no是统一下单时我们生成的UUID    优先使用：transaction_id是统一下单成功  微信返回的
	 */
	/**微信订单号---微信的订单号，优先使用*/
	@XStreamAlias("transaction_id")
	private String transaction_id = ObjectUtils.getUUID();
	/**商户订单号---商户系统内部的订单号，当没提供transaction_id时需要传这个*/
	@XStreamAlias("out_trade_no")
	private String out_trade_no;
	
	/**随机字符串---随机字符串，不长于32位。推荐随机数生成算法*/
	@XStreamAlias("nonce_str")
	private String nonce_str = ObjectUtils.getUUID();
	/**签名---服务商生成的签名，规则详见签名生成算法*/
	@XStreamAlias("sign")
	private String sign;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
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
	
}
