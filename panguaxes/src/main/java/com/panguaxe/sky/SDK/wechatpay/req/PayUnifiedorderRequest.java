package com.panguaxe.sky.SDK.wechatpay.req;

import com.panguaxe.sky.config.WeChatPayConfig;
import com.panguaxe.sky.utils.ObjectUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ClassName: PayUnifiedorderRequest 
 * @Description: TODO --- 统一下单
 * @author 作者：Mike
 * @date 2018年11月26日
 */
public class PayUnifiedorderRequest {

	/**应用ID---受理商户的APPID（请登录open.weixin.qq.com查看，注意与公众号的APPID不同）*/
	@XStreamAlias("appid")
	private String appid = WeChatPayConfig.WECHAT_PAY_UNIFIEDORDER_MCH_APPID;
	/**商户号---受理商户的商户号*/
	@XStreamAlias("mch_id")
	private String mch_id = WeChatPayConfig.WECHAT_MCHID;
	/**设备号---终端设备号(门店号或收银设备ID)，默认请传"WEB"---非必传*/
	@XStreamAlias("device_info")
	private String device_info;
	/**随机字符串---随机字符串，不长于32位。推荐随机数生成算法*/
	@XStreamAlias("nonce_str")
	private String nonce_str = ObjectUtils.getUUID();
	/**签名---服务商生成的签名，规则详见签名生成算法*/
	@XStreamAlias("sign")
	private String sign;
	/**签名类型---签名类型，目前支持HMAC-SHA256和MD5，默认为MD5---非必传*/
	@XStreamAlias("sign_type")
	private String sign_type;
	/**商品描述---商品或支付单简要描述*/
	@XStreamAlias("body")
	private String body;
	/**商品详情---商品名称明细列表---非必传*/
	@XStreamAlias("detail")
	private String detail;
	/**附加数据---附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据---非必传*/
	@XStreamAlias("attach")
	private String attach;
	/**商户订单号---商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号*/
	@XStreamAlias("out_trade_no")
	private String out_trade_no;
	/**货币类型---非必传*/
	@XStreamAlias("out_trade_no")
	private String fee_type;
	/**总金额---订单总金额，单位为分，详见支付金额*/
	@XStreamAlias("total_fee")
	private Integer total_fee;
	/**终端IP---用户端实际ip*/
	@XStreamAlias("spbill_create_ip")
	private String spbill_create_ip = WeChatPayConfig.WECHAT_PAY_UNIFIEDORDER_SPBILLIP;
	/**交易起始时间---订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则---非必传*/
	@XStreamAlias("time_start")
	private String time_start;
	/**交易结束时间---订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。订单失效时间是针对订单号而言的，由于在请求支付的时候有一个必传参数prepay_id只有两小时的有效期，所以在重入时间超过2小时的时候需要重新请求下单接口获取新的prepay_id。其他详见时间；规则建议：最短失效时间间隔大于1分钟---非必传*/
	@XStreamAlias("time_expire")
	private String time_expire;
	/**订单优惠标记---商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠---非必传*/
	@XStreamAlias("goods_tag")
	private String goods_tag;
	/**通知地址---接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。*/
	@XStreamAlias("notify_url")
	private String notify_url = WeChatPayConfig.WECHAT_PAY_UNIFIEDORDER_NOTIFYURL;
	/**交易类型---支付类型*/
	@XStreamAlias("trade_type")
	private String trade_type = "APP";
	/**指定支付方式---no_credit--指定不能使用信用卡支付---非必传*/
	@XStreamAlias("limit_pay")
	private String limit_pay;
	/**场景信息---该字段用于统一下单时上报场景信息，目前支持上报实际门店信息。{"store_id": "", //门店唯一标识，选填，String(32)"store_name":"”//门店名称，选填，String(64)}---非必传*/
	@XStreamAlias("scene_info")
	private String scene_info;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public String getScene_info() {
		return scene_info;
	}

	public void setScene_info(String scene_info) {
		this.scene_info = scene_info;
	}
	
	
}
