package com.panguaxe.sky.common;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
/**
 * @Author 作者 : Panguaxe
 * @Description //TODO 
 * @Date: 2019年07月17日 11:08
 **/
public class ResultEntity<T> {

	/** 描述 : api调用的结果编码 ,不能为空 */
	private Integer resultCode;
	/** 描述 : 系统执行的异常编码*/
	private Integer exceptionCode;
	/** 描述 ：系统数据执行返回的数据，可以为null */
	private T data;
	/** 描述 ：系统或者接口要返回的唯一id标识，不可以为空 */
	private String orderid;
	/** 描述 ：接口调用的时候返回的统一错误信息 */
	private String message;
	/** 描述 ：接口调用的时候需要根据这个id查询状态 */
	private String queryOrderID;
	/** 描述 ：请求form表单返回的html代码 */
	private String html;
	/** 描述 ：第三方接口返回码 ,可能为空，一般有值 */
	private String code;
	/** 描述 ：请求http状态码*/
	private Integer httpCode;

	public Integer getExceptionCode() {
		return exceptionCode;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public void setExceptionCode(Integer exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getOrderid() {
		if (StringUtils.isEmpty(orderid)) {
			orderid = UUID.randomUUID().toString().replace("-", "");
		}
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getQueryOrderID() {
		return queryOrderID;
	}

	public void setQueryOrderID(String queryOrderID) {
		this.queryOrderID = queryOrderID;
	}


	public String getHtml() {
		return html;
	}

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
