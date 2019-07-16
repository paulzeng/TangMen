package com.panguaxe.sky.SDK.faceocr.enums;


public enum FaceOCRStatusEnum {

    AUTHENTICATION_ERROR(401,"AUTHENTICATION_ERROR","api_key和api_secret不匹配"),
    AUTHORIZATION_ERROR(403,"AUTHORIZATION_ERROR","api_key没有调用本API的权限，具体原因为：用户自己禁止该api_key调用、管理员禁止该api_key调用、由于账户余额不足禁止调用"),
    CONCURRENCY_LIMIT_EXCEEDED(403,"CONCURRENCY_LIMIT_EXCEEDED","并发数超过限制。"),
    MISSING_ARGUMENTS(400,"MISSING_ARGUMENTS","缺少某个必选参数"),
    BAD_ARGUMENTS(400,"BAD_ARGUMENTS","某个参数解析出错（比如必须是数字，但是输入的是非数字字符串; 或者长度过长，etc.）"),
    COEXISTENCE_ARGUMENTS(400,"COEXISTENCE_ARGUMENTS","同时传入了要求是二选一或多选一的参数。如有特殊说明则不返回此错误"),
    REQUEST_ENTITY_TOO_LARGE(413,"Request Entity Too Large","客户发送的请求大小超过了2MB限制。该错误的返回格式为纯文本，不是json格式。"),
    API_NOT_FOUND(404,"API_NOT_FOUND","所调用的API不存在。"),
    INTERNAL_ERROR(500,"INTERNAL_ERROR","服务器内部错误，当此类错误发生时请再次请求，如果持续出现此类错误，请及时联系技术支持团队。");

    public static void main(String[] args) {
        System.out.println(getReturnMsg("MISSING_ARGUMENTS: image_url, image_file, image_base64"));
        System.out.println(getReturnMsg("AUTHENTICATION_ERROR"));
    }

    public static String getReturnMsg(String errorMsg) {
        String errMsg = "";
        FaceOCRStatusEnum[] values = FaceOCRStatusEnum.values();
        for (FaceOCRStatusEnum faceOCRStatusEnum : values) {
            String resultMsg = faceOCRStatusEnum.getResultMsg();
            if (errorMsg.startsWith(resultMsg)) {
                errMsg = "HTTP 状态代码：" + faceOCRStatusEnum.getResultCode() + "; 错误信息：" + faceOCRStatusEnum.getResultMsg() + "; 错误信息说明: " + faceOCRStatusEnum.getResultDesc();
                break;
            }
        }
        return errMsg;
    }

    private Integer resultCode;
    private String resultMsg;
    private String resultDesc;

    FaceOCRStatusEnum() {
    }

    FaceOCRStatusEnum(Integer resultCode, String resultMsg, String resultDesc) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultDesc = resultDesc;
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
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    private static final String SERVER_URL = "https://api-cn.faceplusplus.com/cardpp/v1/";

    public static enum FACE_OCR_URL {
        OCR_ID_CARD("1","ocridcard"),
        OCR_BANK_CARD("2","ocrbankcard");

        private String type;

        private String url;

        /**
         * @Author 作者 : Ascetic Monk
         * @Description //TODO              根据类型获取对应的URL
         * @Date: 2019年7月4日 10:32
         * @param type
         * @return java.lang.String
         **/
        public static String getReqURL(String type) {
            String url = "";
            FACE_OCR_URL[] values = FACE_OCR_URL.values();
            for (FACE_OCR_URL faceOCR : values) {
                if (faceOCR.getType().equals(type)) {
                    url = SERVER_URL + faceOCR.getUrl();
                    break;
                }
            }
            return url;
        }

        FACE_OCR_URL(String type, String url) {
            this.type = type;
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
