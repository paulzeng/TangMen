package com.panguaxe.sky.enums;

public enum GlobalEnums {

    /**API成功*/
    API_SUCCESS_CODE("10000","执行成功"),
    /**API失败*/
    API_FAIL_CODE("10001","执行失败"),
    /**Token认证成功*/
    API_TOKEN_AUTHENTICATIONOK("10000","Token认证成功!"),
    /**Token认证过期*/
    API_TOKEN_EXPIRE("18300665808","Token认证过期!"),
    /**网络异常*/
    API_NETWORK_ANOMALY("500","👻,请联系管理员[网络异常18300665808]!");
    /**信息码*/
    private String msgCode;
    /**信息说明*/
    private String message;

    public static void main(String[] args) {
        System.out.println(getReturnMsg("10000"));
        System.out.println(API_NETWORK_ANOMALY.getMessage());
        System.out.println(API_SUCCESS_CODE.getMsgCode());
        System.out.println(RESULT_CODE_ENUMS.RESULT_HANDLING_EXCEPTION.getResultCode());
        System.out.println(RESULT_CODE_ENUMS.getReturnMsg(409));
        System.out.println(PLAT_TYPE.ALLINPAY_PLAT.getPlatName());

    }
    /**
     * @MethodName:  getReturnMsg
     * @Param:       [code]
     * @Return:      java.lang.String
     * @Author:      Panguaxe
     * @Date:        2019/7/11 21:55
     * @Description: TODO               根据错误码获取错误信息描述
     */
    public static String getReturnMsg(String code) {
        String errMsg = "";
        GlobalEnums[] values = GlobalEnums.values();
        for (GlobalEnums globalErrorCodeEnums : values) {
            if (globalErrorCodeEnums.getMsgCode().equals(code)) {
                errMsg = "错误码：" + code + "; 错误信息：" + globalErrorCodeEnums.getMessage();
                break;
            }
        }
        return errMsg;
    }

    GlobalEnums(String msgCode, String message) {
        this.msgCode = msgCode;
        this.message = message;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GlobalErrorCodeEnums{" +
                "msgCode='" + msgCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
    /**
     * @Description: 101代表接口执行失败, 200代表接口执行成功，
     *               202(已接受)服务器已接受请求，但尚未处理。(处理中)，204(无内容)服务器成功处理了请求，但没有返回任何内容。
     *               400(错误请求)服务器不理解请求的语法, 404(未找到)服务器找不到请求的网页。405(网络异常)网络请求异常.
     *               408(请求超时)服务器等候请求时发生超时 ,409(处理异常)结果处理异常，411代表数据校验出错问题
     *               500(服务器内部错误)服务器遇到错误，无法完成请求。504(网关超时)服务器作为网关或代理，但是没有及时从上游服务器收到请求。
     * @Author:      Panguaxe
     * @Date:        2019/7/11 22:01
     * @Description: TODO
     */
    public static enum RESULT_CODE_ENUMS {
        /**代表接口执行失败*/
        FAIL_PORT_EXECUTE(101,"代表接口执行失败"),
        /**代表接口执行成功*/
        SUEECEE_CODE(200,"代表接口执行成功"),
        /**处理中*/
        TO_BE_PROCESSED(202,"(已接受)服务器已接受请求，但尚未处理。(处理中)"),
        /**没有返回任何内容*/
        NO_CONTENT_RETURNED(204,"(无内容)服务器成功处理了请求，但没有返回任何内容。"),
        /**错误请求*/
        BAD_REQUEST(400,"(错误请求)服务器不理解请求的语法"),
        /**找不到请求的网页*/
        NOT_FOUND(404,"(未找到)服务器找不到请求的网页"),
        /**网络异常*/
        NETWORK_ANOMALY(405,"(网络异常)网络请求异常."),
        /**请求超时*/
        REQUEST_TIMEOUT(408,"(请求超时)服务器等候请求时发生超时"),
        /**处理异常*/
        RESULT_HANDLING_EXCEPTION(409,"(处理异常)结果处理异常"),
        /**代表数据校验出错问题*/
        ERROR_DATA_VALIDATE(411,"代表数据校验出错问题 "),
        /**服务器内部错误*/
        SERVER_INTERNAL_ERROR(500,"(服务器内部错误)服务器遇到错误，无法完成请求"),
        /**网关超时*/
        GATEWAY_TIMEOUT(504,"(网关超时)服务器作为网关或代理，但是没有及时从上游服务器收到请求。");

        public static String getReturnMsg(Integer code) {
            String errMsg = "";
            RESULT_CODE_ENUMS[] values = RESULT_CODE_ENUMS.values();
            for (RESULT_CODE_ENUMS resultCodeEnums : values) {
                if (resultCodeEnums.getResultCode().equals(code)) {
                    errMsg = "错误码：" + code + "; 错误信息：" + resultCodeEnums.getResultMsg();
                    break;
                }
            }
            return errMsg;
        }
        /***/
        private Integer resultCode;
        /***/
        private String resultMsg;

        RESULT_CODE_ENUMS(Integer resultCode, String resultMsg) {
            this.resultCode = resultCode;
            this.resultMsg = resultMsg;
        }

        public Integer getResultCode() {
            return resultCode;
        }

        public void setResultCode(Integer resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }}

    public static enum PLAT_TYPE {
        /**通联平台*/
        ALLINPAY_PLAT("ALLINPAY"),
        /**微信支付*/
        WECHATPAY_PLAT("WECHATPAY"),
        /**快付通大额*/
        KFTPAY_PLAT_KFTL("KFTL"),
        /**快付通小额*/
        KFTPAY_PLAT_KFTS("KFTS");

        /**平台标识*/
        private String platName;

        PLAT_TYPE(String platName) {
            this.platName = platName;
        }

        public String getPlatName() {
            return platName;
        }

        public void setPlatName(String platName) {
            this.platName = platName;
        }
    }

    public static enum WECHAT_PAY_BODY {
        /**发红包*/
        WECHAT_PAY_BODY_RED("RED","发红包"),
        /**会员升级*/
        WECHAT_PAY_BODY_VIP("VIP","会员升级");

        public static String getPayDesc(String paySymbol) {
            String payDesc = "";
            WECHAT_PAY_BODY[] values = WECHAT_PAY_BODY.values();
            for (WECHAT_PAY_BODY payBody : values) {
                if (payBody.getPaySymbol().equals(paySymbol)) {
                    payDesc = "支付标识：[" + paySymbol + "]; 支付说明：[" + payBody.getPayDesc() + "]";
                    break;
                }
            }
            return payDesc;
        }
        /**支付标识*/
        private String paySymbol;
        /**支付说明*/
        private String payDesc;

        WECHAT_PAY_BODY(String paySymbol, String payDesc) {
            this.paySymbol = paySymbol;
            this.payDesc = payDesc;
        }

        public String getPaySymbol() {
            return paySymbol;
        }

        public void setPaySymbol(String paySymbol) {
            this.paySymbol = paySymbol;
        }

        public String getPayDesc() {
            return payDesc;
        }

        public void setPayDesc(String payDesc) {
            this.payDesc = payDesc;
        }
    }
}
