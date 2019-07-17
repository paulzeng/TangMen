package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayGetAgreeReq  
* @Description: TODO(新通联---2.20查询绑卡协议号)  
* @author 作者：Panguaxe
* @date 2019年7月4日
 */
public class IpayGetAgreeReq extends IpayBaseRequest {

	/**
	 * 商户号
	 */
	private String cusid;
	/**
	 * 卡号
	 */
	private String cardno;

	public String getCusid() {
		return cusid;
	}

	public void setCusid(String cusid) {
		this.cusid = cusid;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
}
