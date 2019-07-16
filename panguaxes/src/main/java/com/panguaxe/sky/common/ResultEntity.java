package com.panguaxe.sky.common;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @Title: ResultEntity
 * @Description:
 * @Company:
 * @author: xupengfei
 * @created: 2018年7月12日 下午7:02:25
 */

public class ResultEntity<T> {

	/** 描述 (@author: xupengfei) api调用的结果编码 ,不能为空 */
	private Integer resultCode;
	/**
	 * 描述 (@author: xupengfei) 系统执行的异常编码
	 * ，可能为null，这种一般出现在有些代码执行成功，比如接口调用，数据添加等，但是后续代码抛出异常
	 */
	private Integer exceptionCode;
	/** 描述 (@author: xupengfei) 系统数据执行返回的数据，可以为null */
	private T data;
	/** 描述 (@author: xupengfei) 系统或者接口要返回的唯一id标识，不可以为空 */
	private String oederid;
	/** 描述 (@author: xupengfei) 接口调用的时候返回的统一错误信息 */
	private String message;
	/** 描述 (@author: xupengfei) 接口调用的时候需要根据这个id查询状态 */
	private String queryOrderID;

	/** 描述 (@author: xupengfei) 请求form表单返回的html代码 */

	private String html;
	/** 描述 (@author: xupengfei) 第三方接口返回码 ,可能为空，一般有值 */
	private String code;

	private Integer httpCode;
	/**
	 * @author: xupengfei
	 * @created: 2018年7月12日 下午7:05:27
	 * @return: Integer
	 */

	public Integer getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * @author: yinzhixi
	 * @created: 2018年7月12日 下午7:16:55
	 * @return: Integer
	 */

	public Integer getResultCode() {
		return resultCode;
	}

	/**
	 * @author: yinzhixi
	 * @created 2018年7月12日 下午7:16:55
	 * @param resultCode
	 */
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @author: xupengfei
	 * @created 2018年7月12日 下午7:05:27
	 * @param exceptionCode
	 */
	public void setExceptionCode(Integer exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	/**
	 * @author: xupengfei
	 * @created: 2018年7月12日 下午7:05:27
	 * @return: T
	 */

	public T getData() {
		return data;
	}

	/**
	 * @author: xupengfei
	 * @created 2018年7月12日 下午7:05:27
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @author: xupengfei
	 * @created: 2018年7月12日 下午7:05:27
	 * @return: String
	 */

	public String getOederid() {
		if (StringUtils.isEmpty(oederid)) {
			oederid = UUID.randomUUID().toString().replace("-", "");
		}
		return oederid;
	}

	/**
	 * @author: xupengfei
	 * @created 2018年7月12日 下午7:05:27
	 * @param oederid
	 */
	public void setOederid(String oederid) {
		this.oederid = oederid;
	}

	/**
	 * @author: xupengfei
	 * @created: 2018年7月15日 下午8:35:50
	 * @return: String
	 */

	public String getMessage() {
		return message;
	}

	/**
	 * @author: xupengfei
	 * @created 2018年7月15日 下午8:35:50
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @author: xupengfei
	 * @created: 2018年7月16日 下午1:48:19
	 * @return: String
	 */

	public String getQueryOrderID() {
		return queryOrderID;
	}

	/**
	 * @author: xupengfei
	 * @created 2018年7月16日 下午1:48:19
	 * @param queryOrderID
	 */
	public void setQueryOrderID(String queryOrderID) {
		this.queryOrderID = queryOrderID;
	}

	/**
	 * @author: xupengfei
	 * @created: 2018年8月4日 下午1:50:03
	 * @return: String
	 */

	public String getHtml() {
		return html;
	}

	/**
	 * @author: xupengfei
	 * @created 2018年8月4日 下午1:50:03
	 * @param html
	 */
	public void setHtml(String html) {
		this.html = html;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}

}
