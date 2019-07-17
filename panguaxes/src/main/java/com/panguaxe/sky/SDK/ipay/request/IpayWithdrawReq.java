package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayWithdrawReq  
* @Description: TODO(新通联---2.15提现)  
* @author 作者：Panguaxe
* @date 2019年7月4日
 */
public class IpayWithdrawReq extends IpayBaseRequest {

	/** 商户号 */
	private String cusid;
	/** 商户提现流水 */
	private String orderid;
	/** 提现金额---单位分 */
	private String amount;
	/** 全额提现---如果设置了全额提取,则amount无效---1-代表全额提取 */
	private String isall;
	/** 手续费为空,则读取商户入网设置的产品手续费不为空,不允许低于该商户所属代理商的手续费,建议为空*/
	private String fee;
	/**
	 * 交易备注---用于用户订单个性化信息 交易完成通知会带上本字段
	 */
	private String trxreserve;
	/** 交易结果通知地址 接收交易结果通知回调地址,必须为直接可访问的,不能携带参数。 */
	private String notifyurl = "http://webapp.zgzngj.com";

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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getIsall() {
		return isall;
	}

	public void setIsall(String isall) {
		this.isall = isall;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getTrxreserve() {
		return trxreserve;
	}

	public void setTrxreserve(String trxreserve) {
		this.trxreserve = trxreserve;
	}

	public String getNotifyurl() {
		return notifyurl;
	}

	public void setNotifyurl(String notifyurl) {
		this.notifyurl = notifyurl;
	}

}
