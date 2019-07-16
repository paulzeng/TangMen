package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayQueryPayReq  
* @Description: TODO(新通联---2.17提现(付款)交易查询)  
* @author 作者：Mike  
* @date 2019年7月4日
 */
public class IpayQueryPayReq extends IpayBaseRequest {

	/** 商户号 */
	private String cusid;
	/** 商户付款流水 */
	private String orderid;
	/**
	 * 平台交易流水---orderid和trxid必填其一 建议:商户如果同时拥有trxid和orderid,优先使用trxid
	 */
	private String trxid;
	/** 交易日期yyyyMMdd---如果采用orderid查询,则此字段必填 */
	private String date;

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

	public String getTrxid() {
		return trxid;
	}

	public void setTrxid(String trxid) {
		this.trxid = trxid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
