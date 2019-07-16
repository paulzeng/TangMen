package com.panguaxe.sky.SDK.ipay.request;

/**
* @ClassName: IpayMerchantInputQueryReq  
* @Description: TODO(新通联Ipay---2.3商户进件状态查询请求参数)  
* @author 作者：Mike  
* @date 2019年7月3日
 */
public class IpayMerchantInputQueryReq extends IpayBaseRequest {

	/**
	 * 商户外部唯一标识---必传---长度32
	 */
	private String outcusid;

	public String getOutcusid() {
		return outcusid;
	}

	public void setOutcusid(String outcusid) {
		this.outcusid = outcusid;
	}
}
