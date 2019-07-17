package com.panguaxe.sky.utils.card;

import cn.hutool.http.HttpUtil;
import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * @Title BankCardUtils
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/17 11:26
 **/
@Slf4j
public class BankCardUtils {

    private static final String BANKCARD_URL = "https://apimg.alipay.com/combo.png?d=cashier&t=";
    private static final String BANKCARD_INFO_URL = "https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?_input_charset=utf-8&cardBinCheck=true&cardNo=";

    public static void main(String[] args) {
        APIResult result = getBankCardInfo("6222525629385167");
        System.out.println(JSONObject.fromObject(result));
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          根据银行卡号获取银行卡信息
     * @Date: 2019年07月17日 11:30
     * @Param  * @param cardNo
     * @return java.lang.String
     **/
    public static APIResult getBankCardInfo(String cardNo){
        APIResult result = new APIResult();
        if (ObjectUtils.isEmpty(cardNo)){
            return result.setError("请输入您的银行卡号……");
        }
        //银行代码请求接口 url
        String url = BANKCARD_INFO_URL+cardNo;
        //发送请求，得到 josn 类型的字符串
        String bankCardInfo = HttpUtil.get(url);
        JSONObject bankCard = JSONObject.fromObject(bankCardInfo);
        if (bankCard.containsKey("stat") && bankCard.containsKey("validated")){
            String stat = bankCard.getString("stat");
            String validated = bankCard.getString("validated");
            if ("ok".equals(stat) && "true".equals(validated)){
                String bank = bankCard.getString("bank");
                String logo = BANKCARD_URL + bank;
                bankCard.put("bankLogo",logo);
                String cardType = bankCard.getString("cardType");
                String cardTypeName = ("CC".equals(cardType)) ? "信用卡" : "储蓄卡";
                bankCard.put("cardTypeName",cardTypeName);
                result.setMsg("银行卡信息获取成功!");
            }else {
                JSONArray messages = bankCard.getJSONArray("messages");
                JSONObject Obj = (JSONObject) messages.get(0);
                String errorCodes = Obj.getString("errorCodes");
                String name = Obj.getString("name");
                result.setError(name + " → " + errorCodes);
                bankCard.put("messages",name + " → " + errorCodes);
            }
            result.setData(bankCard);
        }else {
            result.setError(GlobalEnums.API_NETWORK_ANOMALY.getMessage());
        }
        return result;
    }

}
