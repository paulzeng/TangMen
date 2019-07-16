package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayConfirmPayReq  
* @Description: TODO(新通联---2.10快捷交易支付确认)  
* @author 作者：Mike  
* @date 2019年7月4日
 */
public class IpayConfirmPayReq extends IpayBaseRequest {

	/** 商户号 ---必传*/
	private String cusid;
	/** 商户订单号 2019.3.7最新接口文档订单号为该字段---必传*/
	private String trxid;
	/** 商户订单号 2018老接口文档订单号为该字段，2019最新文档中该字段已不存在---必传*/
	private String orderid;
	/** 协议编号 ---必传*/
	private String agreeid;
	/** 短信验证码 ---非必传*/
	private String smscode;
	/** 交易透传信息---支付申请或者错误码为1999返回的thpinfo原样带上 ---非必传*/
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
	public String getSmscode() {
		return smscode;
	}
	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}
	public String getThpinfo() {
		return thpinfo;
	}
	public void setThpinfo(String thpinfo) {
		this.thpinfo = thpinfo;
	}
}
