package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayBindCardConfirmReq  
* @Description: TODO(新通联---2.7商户绑定银行卡确认)  
* @author 作者：Panguaxe
* @date 2019年7月4日
 */
public class IpayBindCardConfirmReq extends IpayBaseRequest{

	/** 商户号 ---长度15---必传 */
	private String cusid;
	/** 商户用户号---长度32---必传 */
	private String meruserid;
	/** 银行卡---长度32---必传 */
	private String cardno;
	/** 账户名 ---长度80---必传 */
	private String acctname;
	/** 卡类型---长度2---必传 */
	private String accttype;
	/** 有效期 ---长度4---非必传---为信用卡时必填 */
	private String validdate;
	/** Cvv2---长度4--- 非必传---为信用卡时必填 */
	private String cvv2;
	/** 身份证号 ---长度50---必传 */
	private String idno;
	/** 预留手机号码 ---长度11---必传 */
	private String tel;
	/** 短信验证码---长度10---必传 */
	private String smscode;
	/** 交易透传信息 ---非必传---签约申请时返回,如果不为空,则原样带上 */
	private String thpinfo;

	public String getCusid() {
		return cusid;
	}

	public void setCusid(String cusid) {
		this.cusid = cusid;
	}

	public String getMeruserid() {
		return meruserid;
	}

	public void setMeruserid(String meruserid) {
		this.meruserid = meruserid;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getAcctname() {
		return acctname;
	}

	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	public String getAccttype() {
		return accttype;
	}

	public void setAccttype(String accttype) {
		this.accttype = accttype;
	}

	public String getValiddate() {
		return validdate;
	}

	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}

	public String getCvv2() {
		return cvv2;
	}

	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
