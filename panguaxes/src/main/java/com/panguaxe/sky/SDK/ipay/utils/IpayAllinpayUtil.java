package com.panguaxe.sky.SDK.ipay.utils;

import com.panguaxe.sky.SDK.ipay.config.IpayAllinPayConfig;
import com.panguaxe.sky.utils.ObjectUtils;
import com.panguaxe.sky.utils.ReflectUtils;
import com.panguaxe.sky.utils.date.DateUtils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class IpayAllinpayUtil {

	public static Map<String, String> getPostParams(Object m) {
		Map<String, String> paramsMap = new HashMap<String, String>();
		try {
			TreeMap<String, Object> objectMap = ReflectUtils.objectToMap(m);
			objectMap.put("orgid", IpayAllinPayConfig.IPAY_INSTITUTIONNO);// 平台分配的机构号
			objectMap.put("appid", IpayAllinPayConfig.IPAY_APPID);// 平台分配的机构APPID
			objectMap.put("version","11");// 接口版本号
			objectMap.put("randomstr", ObjectUtils.getUUID());// 商户自行生成的随机字符串
			objectMap.put("reqip", getHostIp());// 商户自行生成的随机字符串
			objectMap.put("reqtime", DateUtils.getCurrentTimeMillis());// 请求时间戳
			objectMap.put("key", IpayAllinPayConfig.IPAY_APPKEY);// 商户自行生成的随机字符串
			// 参数进行签名
			String params = getParam(objectMap);
			// 进行加密
			String sign = sign(params,IpayAllinPayConfig.IPAY_APPKEY);
			// 存放签名
			paramsMap.put("sign", sign);// 签名
			Iterator<Entry<String, Object>> entries = objectMap.entrySet().iterator();
			while (entries.hasNext()) {
				Entry<String, Object> entry = entries.next();
				if (ObjectUtils.isNotEmpty(entry.getValue())) {
					paramsMap.put(entry.getKey(), String.valueOf(entry.getValue()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paramsMap;
	}

	public static String getParam(TreeMap<String, Object> params) throws Exception {
		if (params.containsKey("sign"))// 签名明文组装不包含sign字段
			params.remove("sign");
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Object> entry : params.entrySet()) {
			if (entry.getValue() != null && ((String) entry.getValue()).length() > 0) {
				sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
			}
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static String sign(String params, String appkey) throws Exception {
		String sign = md5(params.getBytes("UTF-8"));// 记得是md5编码的加签
		return sign;
	}

	public static String md5(byte[] b) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(b);
			byte[] hash = md.digest();
			StringBuffer outStrBuf = new StringBuffer(32);
			for (int i = 0; i < hash.length; i++) {
				int v = hash[i] & 0xFF;
				if (v < 16) {
					outStrBuf.append('0');
				}
				outStrBuf.append(Integer.toString(v, 16).toLowerCase());
			}
			return outStrBuf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return new String(b);
		}
	}

	private static String getHostIp() {
		// 本机IP
		String hostIP = "";
		InetAddress ip = null;
		try {
			boolean bFindIP = false;
			Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				if (bFindIP)
					break;
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = ips.nextElement();
					if (!ip.isLoopbackAddress() && ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
						bFindIP = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != ip)
			hostIP = ip.getHostAddress();
		return hostIP;
	}
}
