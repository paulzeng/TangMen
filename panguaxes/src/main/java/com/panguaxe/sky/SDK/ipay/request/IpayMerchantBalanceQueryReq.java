package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayMerchantBalanceQueryReq  
* @Description: TODO(新通联Ipay---2.14余额查询)  
* @author 作者：Mike  
* @date 2019年7月4日
 */
public class IpayMerchantBalanceQueryReq extends IpayBaseRequest {

	/** 商户号 ---必传*/
	private String cusid;

	public String getCusid() {
		return cusid;
	}

	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
}
