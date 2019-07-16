package com.panguaxe.sky.SDK.aliyun.enums;


public enum AliyunVoiceSendEnum {

	ALI_VS_SUCCESS("00000","调用成功","调用成功"),
	ALI_VS_EMPTYPARAMERROR("10000","参数异常","必传参数有空值()"),
	ALI_VS_PHONEFORMERROR("10001","手机号格式不正确","手机号应为11位手机号"),
	ALI_VS_TEMPPARAMERROR("10003","模板变量不正确","模板参数异常"),
	ALI_VS_SENSITIVEERROR("10004","变量中含有敏感词","变量中含有违法敏感词"),
	ALI_VS_VARIABLENAMEERROR("10005","变量名称不匹配","申请的模板中含有变量名称,变量的名称与所传的变量名称不匹配"),
	ALI_VS_QCELLCORECANNOTFINDERROR("10007","手机号查询不到归属地","所传手机号查询不到归属地"),
	ALI_VS_PRODUCTERROR("10008","产品错误","系统错误,详情请联系客服"),
	ALI_VS_PRICEERROR("10009","价格错误","系统错误,详情请联系客服"),
	ALI_VS_REPEATCALLERROR("10010","重复调用","由于网络原因重复调用接口"),
	ALI_VS_NETWORKERROR("404","网络错误","网络错误,请稍后重试!"),
	ALI_VS_SYSTEMERROR("99999","系统错误","详情请联系客服");
	
	private String returnCode;
	
	private String returnMsg;
	
	private String returnDesc;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getReturnDesc() {
		return returnDesc;
	}

	public void setReturnDesc(String returnDesc) {
		this.returnDesc = returnDesc;
	}
	
	AliyunVoiceSendEnum(String returnCode, String returnMsg, String returnDesc) {
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
		this.returnDesc = returnDesc;
	}

	/**
	* @Title: getReturnCode  
	* @Description: TODO(根据错误码获取错误信息及描述)  
	* @author 作者：Mike 
	* @date 2019年6月1日 
	* @param @param returnCode
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	public static String getReturnCode(String returnCode) {
		String errMsg = "";
		AliyunVoiceSendEnum[] values = AliyunVoiceSendEnum.values();
		for (AliyunVoiceSendEnum voiceSendEnum : values) {
			if (voiceSendEnum.getReturnCode().equals(returnCode)) {
				errMsg = "错误码：" + returnCode + "; 错误信息：" + voiceSendEnum.getReturnMsg() + "; 描述：" + voiceSendEnum.getReturnDesc();
				break;
			}
		}
		return errMsg;
	}
	
	public String getResultCode() {
		return this.returnCode;
	}
	
	public static void main(String[] args) {
		System.out.println(getReturnCode("10008"));
		System.out.println(ALI_VS_SUCCESS.getResultCode());
	}
}
