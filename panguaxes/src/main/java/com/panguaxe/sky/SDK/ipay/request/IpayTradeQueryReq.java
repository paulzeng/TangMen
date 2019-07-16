package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayTradeQueryReq  
* @Description: TODO(新通联---2.13快捷交易查询)  
* @author 作者：Mike  
* @date 2019年7月4日
 */
public class IpayTradeQueryReq extends IpayBaseRequest {

	/** 商户号 ---必传 */
	private String cusid;
	/** 商户订单号 ---必传 */
	private String orderid;
	/**
	 * 支付的收银宝平台流水 如果不为空,则必须为大于0的整数---orderid和trxid必填其一
	 * 建议:商户如果同时拥有trxid和orderid,优先使用trxid
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
