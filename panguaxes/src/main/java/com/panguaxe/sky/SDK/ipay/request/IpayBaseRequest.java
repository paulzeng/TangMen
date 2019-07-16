package com.panguaxe.sky.SDK.ipay.request;

import com.panguaxe.sky.SDK.ipay.config.IpayAllinPayConfig;
import com.panguaxe.sky.utils.ObjectUtils;
import com.panguaxe.sky.utils.date.DateUtils;

/**
* @ClassName: IpayBaseRequest  
* @Description: TODO(新通联Ipay---公共请求参数)  
* @author 作者：Mike  
* @date 2019年7月3日
 */
public class IpayBaseRequest {
	
	public static IpayBaseRequest getInstance() {
		return new IpayBaseRequest();
	}

	/**
	 * 机构号---平台分配的机构号---必传---长度15
	 */
	private String orgid = IpayAllinPayConfig.IPAY_INSTITUTIONNO;
	/**
	 * 平台分配的机构APPID---长度8
	 */
	private String appid = IpayAllinPayConfig.IPAY_APPID;
	/**
	 * 接口版本号---非必传---默认填11---长度2
	 */
	private String version = "11";
	/**
	 * 商户自行生成的随机字符串---必传---长度32
	 */
	private String randomstr = ObjectUtils.getUUID();
	/**
	 * 请求IP---非必传---长度32
	 */
	private String reqip;
	/**
	 * 请求时间戳---非必传---长度32
	 */
	private String reqtime = DateUtils.getCurrentTimeMillis();
	/**
	 * 签名---必传---长度32
	 */
	private String sign;

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRandomstr() {
		return randomstr;
	}

	public void setRandomstr(String randomstr) {
		this.randomstr = randomstr;
	}

	public String getReqip() {
		return reqip;
	}

	public void setReqip(String reqip) {
		this.reqip = reqip;
	}

	public String getReqtime() {
		return reqtime;
	}

	public void setReqtime(String reqtime) {
		this.reqtime = reqtime;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
