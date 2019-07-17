package com.panguaxe.sky.SDK.ipay.config;

import com.panguaxe.sky.enums.GlobalEnums;
import java.util.Arrays;

public class IpayAllinPayConfig {

	private static final String IPAY_SERVERURL ="https://ipay.allinpay.com/apiweb";
	public static final String IPAY_INSTITUTIONNO ="";//机构号
	public static final String IPAY_APPID ="";//APPID
	public static final String IPAY_APPKEY ="";//appkey
	public static final String IPAY_CURRENCY ="CNY";//币种 ---暂只支持CNY
	public static final String IPAY_SUBJECT ="[方寸之间,信用无限;诚信支付,财富hold住]";//订单内容---订单的展示标题
	public static final String IPAY_NOTIFYURL ="http://webapp.zgzngj.com";//订单内容---订单的展示标题
	
	public static void main(String[] args) {
		String reqUrl = IPAY_REQ_URL.IPAY_MERCHANTINPUT_QUERY_URL.getReqUrl();
		System.out.println(reqUrl);
	}
	/**
	* @ClassName: IPAY_REQ_URL  
	* @Description: TODO(获取请求url)  
	* @author 作者：Panguaxe
	* @date 2019年7月4日
	 */
	public static enum IPAY_REQ_URL {
		IPAY_MERCHANTINPUT_URL("/org/addcus"),//2.2商户进件
		IPAY_MERCHANTINPUT_QUERY_URL("/org/cusquery"),//2.3商户进件状态查询
		IPAY_MERCHANT_RATEREVISION_URL("/org/updatesettinfo"),//2.4商户结算/费率信息修改
		IPAY_BINDCARD_URL("/org/bindcard"),//2.5商户绑定消费银行卡
		IPAY_RESENDBINDSMS_URL("/org/resendbindsms"),//2.6重新获取绑卡验证码
		IPAY_BINDCARDCONFIRM_URL("/org/bindcardconfirm"),//2.7商户绑定银行卡确认
		IPAY_UNBINDCARD_URL("/org/unbindcard"),//2.8商户解绑消费银行卡
		IPAY_APPLYPAY_URL("/qpay/applypay"),//2.9快捷交易支付申请
		IPAY_CONFIRMPAY_URL("/qpay/confirmpay"),//2.10快捷交易支付确认
		IPAY_PAYSMS_URL("/qpay/paysms"),//2.11快捷支付短信重新获取
		IPAY_QUICKPASS_URL("/qpay/quickpass"),//2.12快捷小额免短信支付
		IPAY_QUERY_URL("/qpay/query"),//2.13快捷交易查询
		IPAY_BALANCEINQUIRE_URL("/acct/balance"),//2.14余额查询
		IPAY_WITHDRAW_URL("/acct/withdraw"),//2.15提现
		IPAY_PAY_URL("/acct/pay"),//2.16付款
		IPAY_QUERYPAY_URL("/acct/querypay"),//2.17提现(付款)交易查询
		IPAY_GETAGREE_URL("/org/getagree");//2.20查询绑卡协议号
		
		private String reqUrl;

		public String getReqUrl() {
			return reqUrl;
		}

		public void setReqUrl(String reqUrl) {
			this.reqUrl = reqUrl;
		}

		private IPAY_REQ_URL(String reqUrl) {
			this.reqUrl = IPAY_SERVERURL + reqUrl;
		}
		
	}
	/**
	* @ClassName: IPAY_BUSINESS_STATE  
	* @Description: TODO(业务状态码)  
	* @author 作者：Panguaxe
	* @date 2019年7月4日
	 */
	public static enum IPAY_BUSINESS_STATE {
		MERCHANT_STATE_NORMAL("1","正常"),
		MERCHANT_STATE_FROZEN("4","冻结"),
		MERCHANT_STATE_CLOSE("9","关闭"),
		TRADE_SUCCESS("0000","交易成功"),
	    SMS_CONFIRM("1999","需获取短信验证码,进行下一步确认操作"),
	    TRADE_ACCEPTANCE("2000","交易已受理"),
	    TRADE_UNUSUAL0003("0003","交易异常,请查询交易"),
	    TRADE_UNUSUAL3054("3054","交易异常,请查询交易"),
	    CARDNO_ERROR("3004","卡号错误"),
	    TRADE_NOT_ALLOW_CANCEL("3012","原交易不允许撤销或退货"),
	    TRADE_NON_EXISTENT("3035","原交易不存在"),
	    TREATY_NON_EXISTENT("3045","协议不存在"),
	    CARD_OR_MOBILE_ERROR("3046","卡信息或手机号码错误"),
	    RETRIEVE_SMS_CODE("3057","请重新获取验证码"),
	    SMS_CODE_ERROR("3058","短信验证码错误"),
	    SMS_CODE_SEND_ERROR("3059","短信验证码发送失败"),
	    OTHER_ERROR("3999","其他错误");

	    private String code;

	    private String msg;

	    /**
	     * @Author 作者 : Panguaxe
	     * @Description //TODO              根据错误码获取错误信息描述
	     * @Date: 2019年7月4日 10:32
	     * @param code          错误码
	     * @return java.lang.String
	     **/
	    public static String getReturnMsg(String code) {
	        String errMsg = "";
	        IPAY_BUSINESS_STATE[] values = IPAY_BUSINESS_STATE.values();
	        for (IPAY_BUSINESS_STATE ipayBusinessState : values) {
	            if (ipayBusinessState.getCode().equals(code)) {
	                errMsg = "状态码：" + code + "; 状态描述：" + ipayBusinessState.getMsg();
	                break;
	            }
	        }
	        return errMsg;
	    }
	    
	    private IPAY_BUSINESS_STATE() {
		}

		private IPAY_BUSINESS_STATE(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public String getMsgCode() {
	        return this.code;
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getMsg() {
	        return msg;
	    }

	    public void setMsg(String msg) {
	        this.msg = msg;
	    }
	}
	
	private static final String [] SUCCESS_TRXSTATUS = {"1","0000","1999","2000"};
	private static final String [] FAIL_TRXSTATUS = {"4","9","0003"};
		
	
	public static Integer getResultCodeByState(String trxstatus) {
		Integer resultCode = 200;
		boolean flag = Arrays.asList(SUCCESS_TRXSTATUS).contains(trxstatus);
		boolean fall = Arrays.asList(FAIL_TRXSTATUS).contains(trxstatus);
		//以3开头的状态码全是失败
		if (trxstatus.startsWith("3") || fall) {
			resultCode = GlobalEnums.RESULT_CODE_ENUMS.FAIL_PORT_EXECUTE.getResultCode();
		}else if (flag) {//如果状态码是【1,0000,1999,2000】都是成功
			resultCode = GlobalEnums.RESULT_CODE_ENUMS.SUEECEE_CODE.getResultCode();
		}else {//否则文档未说明的状态 均认为是失败的
			resultCode = GlobalEnums.RESULT_CODE_ENUMS.FAIL_PORT_EXECUTE.getResultCode();
		}
		return resultCode;
	}
}
