package com.panguaxe.sky.common;

import com.panguaxe.sky.enums.GlobalEnums;

/**
 * @ClassName APIResult
 * @Description TODO :
 * @Author ：Panguaxe
 * @Date 2019/7/11 22:46
 * @Version V1.0
 */
public class APIResult {

    private String msg;
    private Integer msgCode = Integer.parseInt(GlobalEnums.API_SUCCESS_CODE.getMsgCode());
    private Object data;
    private boolean success = true;


    public APIResult() {
        super();
    }

    public APIResult(String msg, Integer msgCode, Object data, boolean success) {
        super();
        this.msg = msg;
        this.msgCode = msgCode;
        this.data = data;
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public APIResult setMsg(String msg) {
        this.msg = msg;
        this.msgCode = Integer.parseInt(GlobalEnums.API_SUCCESS_CODE.getMsgCode());
        this.success = true;
        return this;
    }

    public APIResult setError(String msg) {
        this.msg = msg;
        this.msgCode = Integer.parseInt(GlobalEnums.API_FAIL_CODE.getMsgCode());
        this.success = false;
        return this;
    }

    public Integer getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(Integer msgCode) {
        this.msgCode = msgCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
