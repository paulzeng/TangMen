package com.panguaxe.sky.SDK.aliyun.api;

import com.panguaxe.sky.SDK.aliyun.config.AliyunVoiceSendConfig;
import com.panguaxe.sky.SDK.aliyun.enums.AliyunVoiceSendEnum;
import com.panguaxe.sky.SDK.aliyun.util.HttpUtils;
import com.panguaxe.sky.common.ResultEntity;
import com.panguaxe.sky.enums.GlobalEnums;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AliyunVoiceSendAPI
 * @Description: TODO(阿里云语音发送API)
 * @author 作者：Panguaxe
 * @date 2019年6月1日
 */
public class AliyunVoiceSendAPI {
	
	public static final Logger log = LoggerFactory.getLogger(AliyunVoiceSendAPI.class);
	public static String NOKOWN_ERROR_MSG = "未知错误发生!";
	public static String NETWORK_ERROR_MSG = "网络错误,请稍后重试!";
	
	public static AliyunVoiceSendAPI getInstance() {
		return new AliyunVoiceSendAPI();
	}
	
	/**
	* @Title: aliyunVoiceSend  
	* @Description: TODO(阿里云发送语音验证码)  
	* @author 作者：Panguaxe
	* @date 2019年6月1日 
	* @param @param smsCode			生成的验证码
	* @param @param phone			接收手机号
	* @param @return    参数  
	* @return ResultEntity<JSONObject>    返回类型  
	* @throws
	 */
	public ResultEntity<JSONObject> aliyunVoiceSend(String verifCode, String phone) {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		log.info("验证码:{},手机号:{}", verifCode, phone);
		JSONObject result = aliyunVoiceSendHttp(verifCode, phone);
		log.info("返回结果:{}", result);
		res.setData(result);
		if (result.containsKey("return_code")) {
			String return_code = result.getString("return_code");
			if(result.containsKey("httpCode")) res.setHttpCode(result.getInt("httpCode"));;
			String msgDesc = AliyunVoiceSendEnum.getReturnCode(return_code);
			res.setCode(return_code);
			res.setMessage(msgDesc);
			res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.FAIL_PORT_EXECUTE.getResultCode());
			if (AliyunVoiceSendEnum.ALI_VS_SUCCESS.getResultCode().equals(return_code)) {
				res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.SUEECEE_CODE.getResultCode());
			}
		} else {
			res.setMessage(NOKOWN_ERROR_MSG);
			res.setCode(GlobalEnums.RESULT_CODE_ENUMS.SERVER_INTERNAL_ERROR.getResultMsg().toString());
			res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.FAIL_PORT_EXECUTE.getResultCode());
		}
		return res;
	}

	public JSONObject aliyunVoiceSendHttp(String verifCode, String phone) {
		JSONObject data = new JSONObject();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "APPCODE " + AliyunVoiceSendConfig.ALIYUN_APPCODE);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("code", "code:" + verifCode);
		querys.put("phone", phone);
		Map<String, String> bodys = new HashMap<String, String>();
		try {
			data = HttpUtils.doPost(AliyunVoiceSendConfig.ALIYUN_HOST, AliyunVoiceSendConfig.ALIYUN_PATH,
					AliyunVoiceSendConfig.ALIYUN_METHOD, headers, querys, bodys);
		} catch (Exception e) {
			data.put("return_code", GlobalEnums.RESULT_CODE_ENUMS.NETWORK_ANOMALY.getResultCode());
			data.put("errMsg", NETWORK_ERROR_MSG);
			e.printStackTrace();
		}
		return data;
	}
}
