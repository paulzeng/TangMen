package com.panguaxe.sky.SDK.ipay.api;

import com.panguaxe.sky.SDK.ipay.config.IpayAllinPayConfig;
import com.panguaxe.sky.SDK.ipay.request.*;
import com.panguaxe.sky.SDK.ipay.utils.IpayAllinpayUtil;
import com.panguaxe.sky.common.ResultEntity;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.utils.ObjectUtils;
import com.panguaxe.sky.utils.http.OkHttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sf.json.JSONObject;
import okhttp3.MediaType;

import java.util.Map;

/**
* @ClassName: IpayAllinPayAPI  
* @Description: TODO(新通联统一入口API)  
* @author 作者：Mike  
* @date 2019年7月4日
 */
public class IpayAllinPayAPI {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	public static final Logger log = LoggerFactory.getLogger(IpayAllinPayAPI.class);
	public static String ERROR_PARAM_MESSAGE = "请求参数异常";
	public static String ERROR_NOKOWN_MESSAGE = "网络异常";

	public static IpayAllinPayAPI getInstance() {
		return new IpayAllinPayAPI();
	}
	/**
	* @Title: ipayMerchantInput
	* @Description: TODO(新通联Ipay---2.2商户进件)
	* @author 作者：Mike
	* @date 2019年7月3日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayMerchantInput(IpayMerchantInputReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_MERCHANTINPUT_URL.getReqUrl(),
				req.getOutcusid(), false, null);
	}
	/**
	* @Title: ipayMerchantInputQuery
	* @Description: TODO(新通联Ipay---2.3商户进件状态查询)
	* @author 作者：Mike
	* @date 2019年7月3日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayMerchantInputQuery(IpayMerchantInputQueryReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_MERCHANTINPUT_QUERY_URL.getReqUrl(),
				req.getOutcusid(), true, "state");
	}

	/**
	* @Title: ipayMerchantRateRevision
	* @Description: TODO(新通联Ipay---2.4商户结算/费率信息修改)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayMerchantRateRevision(IpayMerchantRateRevisionReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_MERCHANT_RATEREVISION_URL.getReqUrl(),
				req.getCusid(), false, null);
	}
	/**
	* @Title: ipayBindCard
	* @Description: TODO(新通联Ipay---2.5商户绑定消费银行卡)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayBindCard(IpayBindCardReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_BINDCARD_URL.getReqUrl(),
				req.getCusid(), true, "trxstatus");
	}
	/**
	* @Title: ipayResendBindSms
	* @Description: TODO(新通联Ipay---2.6重新获取绑卡验证码)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayResendBindSms(IpayResendBindSmsReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_RESENDBINDSMS_URL.getReqUrl(),
				req.getCusid(), false, null);
	}
	/**
	* @Title: ipayBindCardConfirm
	* @Description: TODO(新通联Ipay---2.7商户绑定银行卡确认)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayBindCardConfirm(IpayBindCardConfirmReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_BINDCARDCONFIRM_URL.getReqUrl(),
				req.getCusid(), true, "trxstatus");
	}
	/**
	* @Title: ipayUnBindCard
	* @Description: TODO(新通联Ipay---2.8商户解绑消费银行卡)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayUnBindCard(IpayUnBindCardReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_UNBINDCARD_URL.getReqUrl(),
				req.getCusid(), false, null);
	}
	/**
	* @Title: ipayApplyPay
	* @Description: TODO(新通联Ipay---2.9快捷交易支付申请)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayApplyPay(IpayApplyPayReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_APPLYPAY_URL.getReqUrl(),
				req.getAgreeid(), true, "trxstatus");
	}
	/**
	* @Title: ipayConfirmPay
	* @Description: TODO(新通联Ipay---2.10快捷交易支付确认)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayConfirmPay(IpayConfirmPayReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_CONFIRMPAY_URL.getReqUrl(),
				req.getTrxid(), true, "trxstatus");
	}
	/**
	* @Title: ipayPaySms
	* @Description: TODO(新通联Ipay---2.11快捷支付短信重新获取)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayPaySms(IpayPaySmsReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_PAYSMS_URL.getReqUrl(),
				req.getAgreeid(), false, null);
	}
	/**
	* @Title: ipayQuickPass
	* @Description: TODO(新通联Ipay---2.12快捷小额免短信支付)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayQuickPass(IpayQuickPassReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_QUICKPASS_URL.getReqUrl(),
				req.getAgreeid(), true, "trxstatus");
	}
	/**
	* @Title: ipayTradeQuery
	* @Description: TODO(新通联Ipay---2.13快捷交易查询)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayTradeQuery(IpayTradeQueryReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_QUERY_URL.getReqUrl(),
				req.getCusid(), true, "trxstatus");
	}
	/**
	* @Title: ipayMerchantBalanceQuery
	* @Description: TODO(新通联Ipay---2.14余额查询)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayMerchantBalanceQuery(IpayMerchantBalanceQueryReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_BALANCEINQUIRE_URL.getReqUrl(),
				req.getCusid(), false, null);
	}
	/**
	* @Title: ipayWithdraw
	* @Description: TODO(新通联Ipay---2.15提现)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayWithdraw(IpayWithdrawReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_WITHDRAW_URL.getReqUrl(),
				req.getCusid(), true, "trxstatus");
	}
	/**
	* @Title: ipayPay
	* @Description: TODO(新通联Ipay---2.16付款)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayPay(IpayPayReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_PAY_URL.getReqUrl(),
				req.getCusid(), true, "trxstatus");
	}
	/**
	* @Title: ipayQueryPay
	* @Description: TODO(新通联Ipay---2.17提现(付款)交易查询)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayQueryPay(IpayQueryPayReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_QUERYPAY_URL.getReqUrl(),
				req.getCusid(), true, "trxstatus");
	}
	/**
	* @Title: ipayGetAgree
	* @Description: TODO(新通联Ipay---2.20查询绑卡协议号)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @throws
	 */
	public ResultEntity<JSONObject> ipayGetAgree(IpayGetAgreeReq req) throws Exception {
		ResultEntity<JSONObject> res = new ResultEntity<JSONObject>();
		return exceteState(res, req, IpayAllinPayConfig.IPAY_REQ_URL.IPAY_GETAGREE_URL.getReqUrl(),
				req.getCusid(), false, null);
	}

	/**
	* @Title: exceteState
	* @Description: TODO(统一执行)
	* @author 作者：Mike
	* @date 2019年7月4日
	* @param @param m				请求参数
	* @param @param reqUrl			请求地址
	* @param @param orderNo			订单号或商户标识
	* @param @param isHasStatus		是否有内部状态
	* @param @param statusName		内部状态名
	* @throws
	 */
	private ResultEntity<JSONObject> exceteState(ResultEntity<JSONObject> res, Object m, String reqUrl, String orderNo,
			boolean isHasStatus, String statusName) throws Exception {
		try {
			// 订单号,如果不为空,先放进去,可能后续会根据订单号查询所用
			if (StringUtils.isNotEmpty(orderNo)) {
				res.setQueryOrderID(orderNo);
			}
			res = getResult(res, reqUrl, m, isHasStatus, statusName);
		} catch (Exception e) {
			log.info("\n" + "调用getResult异常：{}", e.getMessage());
		}
		return res;
	}

	/**
	* @Title: getResult  
	* @Description: TODO(统一发送请求并进行初步业务处理)  
	* @author 作者：Mike 
	* @date 2019年7月4日 
	* @param @param m				请求参数
	* @param @param reqUrl			请求地址
	* @param @param orderNo			订单号或商户标识
	* @param @param isHasStatus		是否有内部状态
	* @param @param statusName		内部状态名
	* @throws
	 */
	private ResultEntity<JSONObject> getResult(ResultEntity<JSONObject> res, String reqUrl, Object m,
			boolean isHasStatus, String statusName) throws Exception {
		// 组装接口的请求参数
		Map<String, String> paramMap = IpayAllinpayUtil.getPostParams(m);
		if (ObjectUtils.isEmpty(paramMap)) {
			res.setMessage(ERROR_PARAM_MESSAGE);
			res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.ERROR_DATA_VALIDATE.getResultCode());
			return res;
		}
		// 调用通联服务接口
		JSONObject reqParams = JSONObject.fromObject(paramMap);
		JSONObject result = OkHttpUtils.doPost(reqUrl, reqParams);
		log.info("\n" + "请求地址：{}", "\n" + reqUrl);
		log.info("\n" + "请求参数：{}", "\n" + reqParams);
		log.info("\n" + "响应结果：{}", "\n" + result.toString());
		String code = result.getString("code");
		res.setCode(code);
		if ("200".equals(code)) {
			res = returnResultHandle(res, reqUrl, paramMap, result, paramMap.toString(), isHasStatus, statusName);
		} else {
			if (result.containsKey("data"))
				res.setData(result.getJSONObject("data"));
			res.setMessage(ERROR_NOKOWN_MESSAGE);
			res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.NETWORK_ANOMALY.getResultCode());
		}
		return res;
	}

	/**
	* @Title: returnResultHandle  
	* @Description: TODO(统一业务处理  最终返回结果)  
	* @author 作者：Mike 
	* @date 2019年7月4日 
	* @param @param m				请求参数
	* @param @param reqUrl			请求地址
	* @param @param orderNo			订单号或商户标识
	* @param @param isHasStatus		是否有内部状态
	* @param @param statusName		内部状态名
	* @throws
	 */
	private ResultEntity<JSONObject> returnResultHandle(ResultEntity<JSONObject> res, String reqUrl, Object reqParams,
			JSONObject result, String reqParamter, boolean isHasStatus, String statusName) throws Exception {
		try {
			if (result.containsKey("data")) {
				JSONObject resultData = result.getJSONObject("data");// 通联返回data
				if (resultData.containsKey("trxid")) {
					res.setOederid(resultData.getString("trxid"));
				}
				String retcode = resultData.getString("retcode");
				String retmsg = resultData.getString("retmsg");
				res.setCode(retcode);
				res.setData(resultData);
				//是否由小状态  如果有 获取小状态
				if (isHasStatus && "SUCCESS".equals(retcode)) {
					String businessState = resultData.getString(statusName);
					res.setCode(businessState);
				}
				if ("FAIL".equals(retcode)) {// 失败直接返回
					if (resultData.containsKey("errmsg"))
						retmsg = resultData.getString("errmsg");
					res.setMessage(retmsg);
					res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.FAIL_PORT_EXECUTE.getResultCode());
				} else {// 成功
					res.setMessage(retmsg);
					res.setResultCode(GlobalEnums.RESULT_CODE_ENUMS.SUEECEE_CODE.getResultCode());
					if (isHasStatus) {
						String businessState = resultData.getString(statusName);
						String returnMsg = IpayAllinPayConfig.IPAY_BUSINESS_STATE.getReturnMsg(businessState);
						res.setMessage(returnMsg);
						Integer resultCode = IpayAllinPayConfig.getResultCodeByState(businessState);
						res.setResultCode(resultCode);
					}
				}
			} else {
				Integer resultCode = GlobalEnums.RESULT_CODE_ENUMS.NO_CONTENT_RETURNED.getResultCode();
				String returnMsg = GlobalEnums.RESULT_CODE_ENUMS.getReturnMsg(resultCode);
				res.setMessage(returnMsg);
				res.setResultCode(resultCode);
			}
		} catch (Exception e) {
			log.info("\n" + "最终统一处理方法returnResultHandle异常：{}",e.getMessage());
		}
		return res;
	}
}
