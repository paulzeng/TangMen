package com.panguaxe.sky.SDK.ipay.test;


import com.panguaxe.sky.SDK.ipay.api.IpayAllinPayAPI;
import com.panguaxe.sky.SDK.ipay.config.IpayAllinPayConfig;
import com.panguaxe.sky.SDK.ipay.request.*;
import com.panguaxe.sky.common.ResultEntity;
import com.panguaxe.sky.utils.ObjectUtils;
import net.sf.json.JSONObject;

public class IpayAllinPayTest {

	private static String cusid = "101003889193";//商户号
	private static String outcusidQuery = "IPAY_20190704114322300001";
	private static String outcusid = "IPAY_" + ObjectUtils.orderNoGeneration();
	private static String cusname = "殷耀峰";
	private static String merprovice = "410000";
	private static String areacode = "410100";
	private static String legal = "殷耀峰";
	private static String idno = "410482198810107731";
	private static String phone = "18300665808";
	private static String address = "中原路118号";
	private static String acctid = "6226960801122094";// 储蓄卡
	private static String acctname = "殷耀峰";
	private static String accttp = "00";// 00-借记卡/信用卡 01-存折
	private static String prodlist = "[{'trxcode':'QUICKPAY_OF_HP','feerate':'0.50'},{'trxcode':'TRX_PAY','feerate':'2'}]";
	
	private static String meruserid = "IPAY_20190708202519500001";//
	private static String accttype = "02";// 00:借记卡 02:信用卡
	private static String cardno = "6226581038931881";//
	private static String validdate = "0324";//
	private static String cvv2 = "852";//
	private static String smscode = "550831";//
	
	private static String orderNo = "IPAY_" + ObjectUtils.orderNoGeneration();
	private static String agreeid = "201907082027119976";
	private static String  trxcode = "QUICKPAY_OF_HP";
	private static String money = "59800";
	private static String thpinfo = "{\r\n" + 
			"\"sign\": \"\",\r\n" + 
			"\"tphtrxcrtime\": \"\",\r\n" + 
			"\"tphtrxid\": 0,\r\n" + 
			"\"trxflag\": \"trx\",\r\n" + 
			"\"trxsn\": \"\"\r\n" + 
			"}";
	private static String trxid = "19070000000115";
	private static String cityNo = "410100";
	private static String mccid = "M011";
	
	

	public static void main(String[] args) throws Exception {
//		System.out.println(result(ipayMerchantInput()));//2.2商户进件
//		System.out.println(result(ipayMerchantInputQuery()));//2.3商户进件状态查询
//		System.out.println(result(ipayMerchantRateRevision()));//2.4商户结算/费率信息修改
//		System.out.println(result(ipayBindCard()));//2.5商户绑定消费银行卡
//		System.out.println(result(ipayResendBindSms()));//2.6重新获取绑卡验证码
//		System.out.println(result(ipayBindCardConfirm()));//2.7商户绑定银行卡确认
//		System.out.println(result(ipayUnBindCard()));//2.8商户解绑消费银行卡
//		System.out.println(result(ipayApplyPay()));//2.9快捷交易支付申请
//		System.out.println(result(ipayConfirmPay()));//2.10快捷交易支付确认
//		System.out.println(result(ipayPaySms()));//2.11快捷支付短信重新获取
//		System.out.println(result(ipayQuickPass()));//2.12快捷小额免短信支付
		System.out.println(result(ipayTradeQuery()));//2.13快捷交易查询
		System.out.println(result(ipayMerchantBalanceQuery()));//2.14余额查询
//		System.out.println(result(ipayWithdraw()));//2.15提现
//		System.out.println(result(ipayPay()));//2.16付款
//		System.out.println(result(ipayQueryPay()));//2.17提现(付款)交易查询
//		System.out.println(result(ipayGetAgree()));//2.20查询绑卡协议号
	}

	private static String result(ResultEntity<JSONObject> resutl) {
		return JSONObject.fromObject(resutl).toString();
	}
	/**2.2商户进件*/
	public static ResultEntity<JSONObject> ipayMerchantInput() throws Exception {
		IpayMerchantInputReq request = new IpayMerchantInputReq();
		request.setBelongorgid(IpayAllinPayConfig.IPAY_INSTITUTIONNO);
		request.setOutcusid(outcusid);
		request.setCusname(cusname);
		request.setCusshortname(cusname);
		request.setMerprovice(merprovice);
		request.setAreacode(areacode);
		request.setLegal(legal);
		request.setIdno(idno);
		request.setPhone(phone);
		request.setAddress(address);
		request.setAcctid(acctid);
		request.setAcctname(acctname);
		request.setAccttp(accttp);
		request.setProdlist(prodlist);
		return IpayAllinPayAPI.getInstance().ipayMerchantInput(request);
	}
	/**2.3商户进件状态查询*/
	public static ResultEntity<JSONObject> ipayMerchantInputQuery() throws Exception {
		IpayMerchantInputQueryReq req = new IpayMerchantInputQueryReq();
		req.setOutcusid(outcusidQuery);
		return IpayAllinPayAPI.getInstance().ipayMerchantInputQuery(req);
	}
	/**2.4商户结算/费率信息修改*/
	public static ResultEntity<JSONObject> ipayMerchantRateRevision() throws Exception{
		IpayMerchantRateRevisionReq request = new IpayMerchantRateRevisionReq();
		request.setCusid(cusid);
//		request.setAcctid(acctid);
//		request.setAccttp(accttp);
		request.setProdlist(prodlist);
//		request.setSettfee(settfee);
		return IpayAllinPayAPI.getInstance().ipayMerchantRateRevision(request);
	}
	/**2.5商户绑定消费银行卡*/
	public static ResultEntity<JSONObject> ipayBindCard() throws Exception{
		IpayBindCardReq req = new IpayBindCardReq();
		req.setCusid(cusid);
		req.setMeruserid(outcusid);
		req.setCardno(cardno);
		req.setAcctname(acctname);
		req.setAccttype(accttype);//00:借记卡 02:信用卡
		req.setValiddate(validdate);
		req.setCvv2(cvv2);
		req.setIdno(idno);
		req.setTel(phone);
		return IpayAllinPayAPI.getInstance().ipayBindCard(req);
	}
	/**2.6重新获取绑卡验证码*/
	public static ResultEntity<JSONObject> ipayResendBindSms() throws Exception{
		IpayResendBindSmsReq req = new IpayResendBindSmsReq();
		req.setCusid(cusid);
		req.setMeruserid(meruserid);
		req.setCardno(cardno);
		req.setAcctname(acctname);
		req.setAccttype(accttype);
		req.setValiddate(validdate);
		req.setCvv2(cvv2);
		req.setIdno(idno);
		req.setTel(phone);
		return IpayAllinPayAPI.getInstance().ipayResendBindSms(req);
	}
	/**2.7商户绑定银行卡确认*/
	public static ResultEntity<JSONObject> ipayBindCardConfirm() throws Exception{
		IpayBindCardConfirmReq req = new IpayBindCardConfirmReq();
		req.setCusid(cusid);
		req.setMeruserid(meruserid);
		req.setCardno(cardno);
		req.setAcctname(acctname);
		req.setAccttype(accttype);
		req.setValiddate(validdate);
		req.setCvv2(cvv2);
		req.setIdno(idno);
		req.setTel(phone);
		req.setSmscode(smscode);
		return IpayAllinPayAPI.getInstance().ipayBindCardConfirm(req);
	}
	/**2.8商户解绑消费银行卡*/
	public static ResultEntity<JSONObject> ipayUnBindCard() throws Exception{
		IpayUnBindCardReq req = new IpayUnBindCardReq();
		req.setCusid(cusid);	
		req.setCardno(cardno);
		return IpayAllinPayAPI.getInstance().ipayUnBindCard(req);
	}
	/**2.9快捷交易支付申请*/
	public static ResultEntity<JSONObject> ipayApplyPay() throws Exception{
		IpayApplyPayReq req = new IpayApplyPayReq();
		req.setCusid(cusid);
		req.setOrderid(orderNo);
		req.setAgreeid(agreeid);
		req.setTrxcode(trxcode);
		req.setAmount(money);
		return IpayAllinPayAPI.getInstance().ipayApplyPay(req);
	}
	/**2.10快捷交易支付确认*/
	public static ResultEntity<JSONObject> ipayConfirmPay() throws Exception{
		IpayConfirmPayReq req = new IpayConfirmPayReq();
		req.setCusid(cusid);
		req.setTrxid(trxid);
		req.setAgreeid(agreeid);
		req.setSmscode(smscode);
		req.setThpinfo(thpinfo);
		return IpayAllinPayAPI.getInstance().ipayConfirmPay(req);
	}
	/**2.11快捷支付短信重新获取*/
	public static ResultEntity<JSONObject> ipayPaySms() throws Exception{
		IpayPaySmsReq req = new IpayPaySmsReq();
		req.setCusid(cusid);
		req.setTrxid(trxid);
		req.setAgreeid(agreeid);
		req.setThpinfo(thpinfo);
		return IpayAllinPayAPI.getInstance().ipayPaySms(req);
	}
	/**2.12快捷小额免短信支付*/
	public static ResultEntity<JSONObject> ipayQuickPass() throws Exception{
		IpayQuickPassReq req = new IpayQuickPassReq();
		req.setCusid(cusid);
		req.setOrderid(orderNo);
		req.setAgreeid(agreeid);
		req.setAmount(money);
		req.setCity(cityNo);
		req.setMccid(mccid);
		return IpayAllinPayAPI.getInstance().ipayQuickPass(req);
	}
	/**2.13快捷交易查询*/
	public static ResultEntity<JSONObject> ipayTradeQuery() throws Exception{
		IpayTradeQueryReq req = new IpayTradeQueryReq();
		req.setCusid(cusid);
		req.setTrxid(trxid);
		return IpayAllinPayAPI.getInstance().ipayTradeQuery(req);
	}
	/**2.14余额查询*/
	public static ResultEntity<JSONObject> ipayMerchantBalanceQuery() throws Exception{
		IpayMerchantBalanceQueryReq req = new IpayMerchantBalanceQueryReq();
		req.setCusid(cusid);
		return IpayAllinPayAPI.getInstance().ipayMerchantBalanceQuery(req);
	}
	/**2.15提现*/
	public static ResultEntity<JSONObject> ipayWithdraw() throws Exception{
		IpayWithdrawReq req = new IpayWithdrawReq();
		req.setCusid(cusid);
		req.setOrderid(orderNo);
		req.setIsall("1");//1-代表全额提取
//		req.setAmount(money);
		return IpayAllinPayAPI.getInstance().ipayWithdraw(req);
	}
	/**2.16付款*/
	public static ResultEntity<JSONObject> ipayPay() throws Exception{
		IpayPayReq req = new IpayPayReq();
		req.setCusid(cusid);
		req.setOrderid(orderNo);
		req.setAmount("1741");
		req.setAgreeid(agreeid);
		return IpayAllinPayAPI.getInstance().ipayPay(req);
	}
	/**2.17提现(付款)交易查询*/
	public static ResultEntity<JSONObject> ipayQueryPay() throws Exception{
		IpayQueryPayReq req = new IpayQueryPayReq();
		req.setCusid(cusid);
		req.setTrxid("19070000000114");
		return IpayAllinPayAPI.getInstance().ipayQueryPay(req);
	}
	/**2.20查询绑卡协议号*/
	public static ResultEntity<JSONObject> ipayGetAgree() throws Exception{
		IpayGetAgreeReq req = new IpayGetAgreeReq();
		req.setCusid(cusid);
		req.setCardno(cardno);
		return IpayAllinPayAPI.getInstance().ipayGetAgree(req);
	}
}
