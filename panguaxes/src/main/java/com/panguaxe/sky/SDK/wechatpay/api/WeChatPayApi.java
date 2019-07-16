package com.panguaxe.sky.SDK.wechatpay.api;

import com.panguaxe.sky.SDK.wechatpay.config.WeChatPayURL;
import com.panguaxe.sky.SDK.wechatpay.req.*;
import com.panguaxe.sky.common.ResultEntity;
import com.panguaxe.sky.config.WeChatPayConfig;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.utils.ObjectUtils;
import com.panguaxe.sky.utils.WeChatDefrayUtils;
import net.sf.json.JSONObject;
import okhttp3.MediaType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Map;

/**
 * ClassName: WeChatPayApi
 * 
 * @Description: TODO --- 微信---支付提现API统一 入口
 * @author 作者：Mike
 * @date 2018年10月26日
 */
public class WeChatPayApi {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	public static final Logger LOGGER = LoggerFactory.getLogger(WeChatPayApi.class);
	/**本地测试证书路径*/
	private static String CERT = "E:\\wx\\apiclient_cert.p12";
	public static String SUCCESS_MESSAGE = "成功！";
	/**出现系统错误的错误码时（SYSTEMERROR）,请务必用原商户订单号重试，或通过查询接口确认此次付款的结果。]，请请务必再请求一次查询接口，以确认此次付款的结果。*/
	public static String FAIL_MESSAGE = "失败！请使用原单号重新尝试！";
	public static String ERROR_SYSTEM_MESSAGE = "接口请求信息发生异常！";
	public static String ERROR_PARAM_MESSAGE = "接口请求信息数据错误！";
	public static String ERR_CODE_SYSTEMERROR = "SYSTEMERROR";
	private static String[] URLS = {"WECHAT_PAY_UNIFIEDORDER", "WECHAT_PAY_ORDERQUERY"};
	

	public static WeChatPayApi getInstance() {

		return new WeChatPayApi();
	}

	/**
	 * @Description: TODO --- 微信支付提现---企业付款
	 * @return ResultEntity<JSONObject>
	 * @throws @author
	 *             作者：Mike
	 * @date 2018年10月26日
	 */
	public ResultEntity<JSONObject> weChatTransfers(TransfersRequest request) {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, request, WeChatPayURL.WECHATPAY_REQ_URL.WECHATPAY_TRANSFERS_URL.getReqUrl(),request.getPartner_trade_no());
	}
	/**
	 * @Description: TODO --- 微信---查询企业付款
	 * @return ResultEntity<JSONObject>  
	 * @throws
	 * @author 作者：Mike
	 * @date 2018年10月31日
	 */
	public ResultEntity<JSONObject> weChatGettransferinfo(GettransferinfoRequest request) {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		//签名
		request.setSign(WeChatDefrayUtils.getSign(WeChatDefrayUtils.buildParamMap(request), WeChatPayConfig.WECHAT_MCH_KEY));
		return exceteState(res, request, WeChatPayURL.WECHATPAY_REQ_URL.WECHATPAY_GETTRANSFERINFO_URL.getReqUrl(),request.getNonce_str());
	}
	/**
	 * @Description: TODO --- 微信---企业付款到银行卡
	 * @return ResultEntity<JSONObject>  
	 * @throws
	 * @author 作者：Mike
	 * @date 2018年10月31日
	 */
	public ResultEntity<JSONObject> weChatPayBank(PayBankRequest request) {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, request,WeChatPayURL.WECHATPAY_REQ_URL.WECHATPAY_PAY_BANK_URL.getReqUrl(),request.getPartner_trade_no());
	}
	
	/**
	 * @Description: TODO --- 获取公钥
	 * @return ResultEntity<JSONObject>  
	 * @throws
	 * @author 作者：Mike
	 * @date 2018年10月31日
	 */
	public ResultEntity<JSONObject> weChatGetpublickey(GetpublickeyRequest request) {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, request,WeChatPayURL.WECHATPAY_REQ_URL.WECHATPAY_GETPUBLICKEY_URL.getReqUrl(),request.getNonce_str());
	}
	/**
	 * @Description: TODO --- 统一下单
	 * @return ResultEntity<JSONObject>  
	 * @throws
	 * @author 作者：Mike
	 * @date 2018年11月26日
	 */
	public ResultEntity<JSONObject> weChatPayUnifiedorder(PayUnifiedorderRequest request) {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		request.setSign(WeChatDefrayUtils.getSign(WeChatDefrayUtils.buildParamMap(request),WeChatPayConfig.WECHAT_MCH_KEY));
		return exceteState(res, request,WeChatPayURL.WECHATPAY_REQ_URL.WECHATPAY_UNIFIEDORDER_URL.getReqUrl(),request.getOut_trade_no());
	}
	/**
	 * @Description: TODO --- 查询订单（统一下单）
	 * @return ResultEntity<JSONObject>  
	 * @throws
	 * @author 作者：Mike
	 * @date 2018年11月27日
	 */
	public ResultEntity<JSONObject> weChatPayOrderquery(PayOrderqueryRequest request) {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, request,WeChatPayURL.WECHATPAY_REQ_URL.WECHATPAY_ORDERQUERY_URL.getReqUrl(),request.getOut_trade_no());
	}

	/**
	 * @Description: TODO --- 通用执行方法
	 * @return ResultEntity<JSONObject>
	 * @throws @author
	 *             作者：Mike
	 * @date 2018年10月26日
	 */
	private ResultEntity<JSONObject> exceteState(ResultEntity<JSONObject> res, Object m, String method,
			String orderNo) {
		// 订单号很重要，查询订单需要
		if (StringUtils.isNotEmpty(orderNo)) {
			res.setQueryOrderID(orderNo);
		}
		try {
			res = getResult(res, method, m);
		} catch (Exception e) {
			res.setMessage(ERROR_SYSTEM_MESSAGE);
			res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.SERVER_INTERNAL_ERROR.getResultCode());
		}
		return res;
	}

	/**
	 * @Description: TODO --- 通用核心业务处理方法
	 * @return ResultEntity<JSONObject>
	 * @throws @author
	 *             作者：Mike
	 * @date 2018年10月26日
	 */
	private ResultEntity<JSONObject> getResult(ResultEntity<JSONObject> res, String reqUrl, Object object) throws Exception {
		String reqXml = WeChatDefrayUtils.sendDataToXml(object);
		LOGGER.info("提现请求报文reqXml:{}", reqXml);
		String postSSL = "";
		//TODO 判断请求是否需要整数
		if (Arrays.asList(URLS).contains(reqUrl)) {
			postSSL = WeChatDefrayUtils.post(reqUrl, reqXml,WeChatPayConfig.WECHAT_PAY_UNIFIEDORDER_MCH_APPID);
		} else {//需要证书的请求
			postSSL = WeChatDefrayUtils.postSSL(reqUrl, reqXml, WeChatPayConfig.WECHAT_MCH_CERT, WeChatPayConfig.WECHAT_MCHID);
		}
		LOGGER.info("微信提现返回结果:{}", postSSL);
		Map<String, String> map = WeChatDefrayUtils.xmlToMap(postSSL);
		String return_code = map.get("return_code");
		String result_code = map.get("result_code");
		String return_msg = map.get("return_msg");
		//当err_code为SYSTEMERROR时,返回该订单号,需要重试,否则可能造成重复支付等资金风险
		String err_code = map.get("err_code");
		String err_code_des = map.get("err_code_des");
		if (ObjectUtils.isNotEmpty(map)) {
			JSONObject j = new JSONObject();
			j = JSONObject.fromObject(map);
			LOGGER.info("微信提现返回结果转JSON结果:{}",j);
			//return_code返回SUCCESS,说明接口请求成功
			if (WeChatPayConfig.RETURN_SUCCESS.equals(return_code)) {
				//result_code返回SUCCESS,说明真实成功
				if (WeChatPayConfig.RETURN_SUCCESS.equals(result_code)) {
					res.setData(j);
					res.setCode(result_code);
					res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.SUEECEE_CODE.getResultCode());
					res.setMessage(SUCCESS_MESSAGE);
				} else {
					//出现系统错误的错误码时（SYSTEMERROR），请务必用原商户订单号重试，或通过查询接口确认此次付款的结果。]，请请务必再请求一次查询接口，以确认此次付款的结果。
					if (ERR_CODE_SYSTEMERROR.equals(err_code)) {
						res.setData(j);
						res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.SERVER_INTERNAL_ERROR.getResultCode());
						res.setCode(err_code);
						res.setMessage(FAIL_MESSAGE);
					} else {
						res.setMessage(err_code_des);
						res.setCode(err_code);
						res.setData(j);
						res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.FAIL_PORT_EXECUTE.getResultCode());
					}
				}
			} else {//return_code返回FAIL,说明接口请求失败,一般为参数问题,此时直接返回错误信息
				res.setMessage(return_msg);
				res.setData(j);
				res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.FAIL_PORT_EXECUTE.getResultCode());
				res.setCode(return_code);
			}
		} else {
			res.setMessage(ERROR_PARAM_MESSAGE);
			res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.NETWORK_ANOMALY.getResultCode());
		}
		return res;
	}
}
