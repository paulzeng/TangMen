package com.panguaxe.sky.SDK.aliyun.test;

import com.panguaxe.sky.SDK.aliyun.api.AliyunVoiceSendAPI;
import com.panguaxe.sky.common.ResultEntity;
import com.panguaxe.sky.utils.ObjectUtils;
import net.sf.json.JSONObject;

/**
 * @Author 作者 : Panguaxe
 * @Description //TODO 
 * @Date: 2019年07月12日 09:29
 * @Param  * @param null
 * @return
 **/
public class AliyunVoiceSendTest {

	private static String verifCode = ObjectUtils.verifCodeGenerator();
	private static String phone = "18300665808";

	public static void main(String[] args) {
		System.out.println(JSONObject.fromObject(aliyunVoiceSend()).toString());
	}

	public static ResultEntity<JSONObject> aliyunVoiceSend() {
		return AliyunVoiceSendAPI.getInstance().aliyunVoiceSend(verifCode, phone);
	}
}
