package com.panguaxe.sky.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


public class RequestUtil {

	/**
	 * 移除request指定参数
	 */
	public String removeParam(HttpServletRequest request, String paramName) {
		String queryString = "";
		Enumeration keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			if (key.equals(paramName)) {
				continue;
			}
			if ("".equals(queryString)) {
				queryString = key + "=" + request.getParameter(key);
			} else {
				queryString += "&" + key + "=" + request.getParameter(key);
			}
		}
		return queryString;
	}

	/**
	 * 获取请求basePath
	 */
	public static String getBasePath(HttpServletRequest request) {
		StringBuffer basePath = new StringBuffer();
		String scheme = request.getScheme();
		String domain = request.getServerName();
		int port = request.getServerPort();
		basePath.append(scheme);
		basePath.append("://");
		basePath.append(domain);
		if("http".equalsIgnoreCase(scheme) && 80 != port) {
			basePath.append(":").append(String.valueOf(port));
		} else if("https".equalsIgnoreCase(scheme) && port != 443) {
			basePath.append(":").append(String.valueOf(port));
		}
		return basePath.toString();
	}

	/**
	 * 请求中参数转Map<String, String>,for支付宝异步回调,平时建议直接使用request.getParameterMap(),返回Map<String, String[]>
	 */
	public static Map<String, String> getParameterMap(HttpServletRequest request) {
		Map<String, String> result = new HashMap<>();
		Enumeration parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			result.put(parameterName, request.getParameter(parameterName));
		}
		return result;
	}

	/**
	 * 获取ip工具类，除了getRemoteAddr，其他ip均可伪造
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 如果是多级代理，那么取第一个ip为客户端ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(0, ip.indexOf(",")).trim();
		}
		return ip;
	}

}
