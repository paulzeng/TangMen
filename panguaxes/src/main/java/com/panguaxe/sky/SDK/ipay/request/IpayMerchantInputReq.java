package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayMerchantInputReq  
* @Description: TODO(新通联Ipay---2.2商户进件请求参数)  
* @author 作者：Panguaxe
* @date 2019年7月3日
 */
public class IpayMerchantInputReq extends IpayBaseRequest {

	/** 拓展代理商号---32位---必传 */
	private String belongorgid;
	/** 商户外部唯一标记 ---32位---必传 */
	private String outcusid;
	/** 商户名称 ---100位---必传 */
	private String cusname;
	/** 商户名称 ---40位---必传 */
	private String cusshortname;
	/** 所在省---8位---必传 */
	private String merprovice;
	/** 所在市 ---8位---必传 */
	private String areacode;
	/** 法人姓名 ---32位---必传 */
	private String legal;
	/** 法人代表证件号---50位---必传 */
	private String idno;
	/** 法人手机号码---11位---必传 */
	private String phone;
	/** 注册地址 ---200位---必传 */
	private String address;
	/** 账户号 ---32位---必传 */
	private String acctid;
	/** 账户名 ---80位---必传 */
	private String acctname;
	/** 卡折类型 ---2位---必传---00-借记卡 01-存折 */
	private String accttp;
	/** 拓展人 ---50位---非必传 */
	private String expanduser;
	/** 支付产品信息列表--产品列表的json--1000位---必传 */
	private String prodlist;
	/** 提现手续费--单位:元/笔 ---例如：2块/笔,该字 段填2.00，为空时，取所属代理商费率---非必传 */
	private String settfee;
	/** 交易类型 ---必传---20长度 */
	private String trxcode;
	/** 费率 ---必传---百分之---长度8---例如0.35代表百分之0.35(最多保留两位小数) */
	private String feerate;

	public String getBelongorgid() {
		return belongorgid;
	}

	public void setBelongorgid(String belongorgid) {
		this.belongorgid = belongorgid;
	}

	public String getOutcusid() {
		return outcusid;
	}

	public void setOutcusid(String outcusid) {
		this.outcusid = outcusid;
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public String getCusshortname() {
		return cusshortname;
	}

	public void setCusshortname(String cusshortname) {
		this.cusshortname = cusshortname;
	}

	public String getMerprovice() {
		return merprovice;
	}

	public void setMerprovice(String merprovice) {
		this.merprovice = merprovice;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getLegal() {
		return legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAcctid() {
		return acctid;
	}

	public void setAcctid(String acctid) {
		this.acctid = acctid;
	}

	public String getAcctname() {
		return acctname;
	}

	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	public String getAccttp() {
		return accttp;
	}

	public void setAccttp(String accttp) {
		this.accttp = accttp;
	}

	public String getExpanduser() {
		return expanduser;
	}

	public void setExpanduser(String expanduser) {
		this.expanduser = expanduser;
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

	public String getTrxcode() {
		return trxcode;
	}

	public void setTrxcode(String trxcode) {
		this.trxcode = trxcode;
	}

	public String getFeerate() {
		return feerate;
	}

	public void setFeerate(String feerate) {
		this.feerate = feerate;
	}
}
