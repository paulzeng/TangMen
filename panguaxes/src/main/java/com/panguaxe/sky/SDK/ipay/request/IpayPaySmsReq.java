package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayPaySmsReq  
* @Description: TODO(新通联---2.11快捷支付短信重新获取)  
* @author 作者：Panguaxe
* @date 2019年7月4日
 */
public class IpayPaySmsReq extends IpayBaseRequest {

	/** 商户号 ---必传 */
	private String cusid;
	/** 商户订单号 ---必传 */
	private String trxid;
	/** 协议编号 ---必传 */
	private String agreeid;
	/** 交易透传信息---支付申请错误码为1999返回的thpinfo原样带上---非必传 */
	private String thpinfo;

	public String getCusid() {
		return cusid;
	}

	public void setCusid(String cusid) {
		this.cusid = cusid;
	}

	public String getTrxid() {
		return trxid;
	}

	public void setTrxid(String trxid) {
		this.trxid = trxid;
	}

	public String getAgreeid() {
		return agreeid;
	}

	public void setAgreeid(String agreeid) {
		this.agreeid = agreeid;
	}

	public String getThpinfo() {
		return thpinfo;
	}

	public void setThpinfo(String thpinfo) {
		this.thpinfo = thpinfo;
	}

}
