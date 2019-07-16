package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayUnBindCardReq  
* @Description: TODO(新通联---2.8商户解绑消费银行卡)  
* @author 作者：Mike  
* @date 2019年7月4日
 */
public class IpayUnBindCardReq extends IpayBaseRequest {

	/** 商户号---必传15 */
	private String cusid;
	/** 银行卡---必传32 */
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
