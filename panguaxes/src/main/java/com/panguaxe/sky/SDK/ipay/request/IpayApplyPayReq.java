package com.panguaxe.sky.SDK.ipay.request;


import com.panguaxe.sky.SDK.ipay.config.IpayAllinPayConfig;

/**
* @ClassName: IpayApplyPayReq  
* @Description: TODO(新通联---2.9快捷交易支付申请)  
* @author 作者：Mike  
* @date 2019年7月4日
 */
public class IpayApplyPayReq extends IpayBaseRequest {

	/** 商户号---必传 */
	private String cusid;
	/** 商户订单号--- 必传*/
	private String orderid;
	/** 协议编号 ---签约返回---必传*/
	private String agreeid;
	/** 交易类型---非必传 */
	private String trxcode;
	/** 订单金额---单位分 ---必传*/
	private String amount;
	/** 币种 ---暂只支持CNY---必传*/
	private String currency = IpayAllinPayConfig.IPAY_CURRENCY;
	/** 订单内容---订单的展示标题---必传 */
	private String subject = IpayAllinPayConfig.IPAY_SUBJECT;
	/** 有效时间---订单有效时间---最大720分钟 ---非必传*/
	private String validtime;
	/** 市别---国标---只对线下交易有效---非必传 */
	private String city;
	/** 行业---只对线下交易有效---非必传 */
	private String mccid;
	/** 交易备注---用于用户订单个性化信息交易完成通知会带上本字段 ---非必传*/
	private String trxreserve;
	/** 交易结果通知地址---接收交易结果通知回调地址，通知url必须为直接可访问的url，不能携带参数。 必传*/
	private String notifyurl = IpayAllinPayConfig.IPAY_NOTIFYURL;
	
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getAgreeid() {
		return agreeid;
	}
	public void setAgreeid(String agreeid) {
		this.agreeid = agreeid;
	}
	public String getTrxcode() {
		return trxcode;
	}
	public void setTrxcode(String trxcode) {
		this.trxcode = trxcode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getValidtime() {
		return validtime;
	}
	public void setValidtime(String validtime) {
		this.validtime = validtime;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMccid() {
		return mccid;
	}
	public void setMccid(String mccid) {
		this.mccid = mccid;
	}
	public String getTrxreserve() {
		return trxreserve;
	}
	public void setTrxreserve(String trxreserve) {
		this.trxreserve = trxreserve;
	}
	public String getNotifyurl() {
		return notifyurl;
	}
	public void setNotifyurl(String notifyurl) {
		this.notifyurl = notifyurl;
	}
}
