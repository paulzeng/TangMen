package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayMerchantRateRevisionReq  
* @Description: TODO(新通联---2.4商户结算/费率信息修改)  
* @author 作者：Mike  
* @date 2019年7月4日
 */
public class IpayMerchantRateRevisionReq extends IpayBaseRequest {

	/** 商户号---必传---长度15 */
	private String cusid;
	/** 账户号---非必传---长度32 */
	private String acctid;
	/** 卡折类型---非必传---长度2---00-借记卡 01-存折 */
	private String accttp;
	/** 产品列表的json---非必传---长度1000 */
	private String prodlist;
	/** 实时到账手续费---非必传---单位:元/笔---例如：2块/笔,该字 段填2.00 */
	private String settfee;

	public String getCusid() {
		return cusid;
	}

	public void setCusid(String cusid) {
		this.cusid = cusid;
	}

	public String getAcctid() {
		return acctid;
	}

	public void setAcctid(String acctid) {
		this.acctid = acctid;
	}

	public String getAccttp() {
		return accttp;
	}

	public void setAccttp(String accttp) {
		this.accttp = accttp;
	}

	public String getProdlist() {
		return prodlist;
	}

	public void setProdlist(String prodlist) {
		this.prodlist = prodlist;
	}

	public String getSettfee() {
		return settfee;
	}

	public void setSettfee(String settfee) {
		this.settfee = settfee;
	}
}
