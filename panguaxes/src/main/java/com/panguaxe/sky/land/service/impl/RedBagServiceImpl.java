package com.panguaxe.sky.land.service.impl;

import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.config.RedBagConfig;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.land.mapper.RedBagMapper;
import com.panguaxe.sky.land.model.Account;
import com.panguaxe.sky.land.model.RedBag;
import com.panguaxe.sky.land.model.RedBagType;
import com.panguaxe.sky.land.model.WeChat;
import com.panguaxe.sky.land.service.IRedBagService;
import com.panguaxe.sky.land.service.IRedBagTypeService;
import com.panguaxe.sky.land.service.IWeChatService;
import com.panguaxe.sky.land.service.WeChatDefrayService;
import com.panguaxe.sky.utils.ObjectUtils;
import com.panguaxe.sky.utils.date.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.SortedMap;

/**
 * @Title RedBagServiceImpl
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 11:22
 **/
@Service
public class RedBagServiceImpl extends BaseService<RedBag> implements IRedBagService {

    @Autowired
    private RedBagMapper redBagMapper;
    @Autowired
    private IRedBagTypeService redBagTypeService;
    @Autowired
    private IWeChatService weChatService;
    @Autowired
    private WeChatDefrayService weChatDefrayService;

    /**
     * @MethodName:  dispenseRedBag
     * @Param:       [request, account, redBag, imgs, video]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:23
     * @Description: TODO               发红包
     */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.NOT_SUPPORTED)
    @Override
    public APIResult dispenseRedBag(HttpServletRequest request, Account account, RedBag redBag, String imgs, String video) {
        APIResult result = new APIResult();
        String orderNo = ObjectUtils.getUUID();
        redBag.setId(orderNo);
        //TODO 红包类型、红包金额、支付方式 、红包个数
        String type = redBag.getRedBagType();
        BigDecimal money = redBag.getAmount();
        String payType = redBag.getPayType();
        Integer num = redBag.getNum();
        //TODO 查询红包类型配置
        RedBagType redBagType = redBagTypeService.findByTypeCode(type);
        //TODO 查询用户微信数据
        WeChat weChat = weChatService.findWeChatByTelOrAccount(account.getId(), account.getTelephone());
        if (ObjectUtils.isEmpty(weChat)){
            return result.setError("请微信授权后发红包!");
        }
        //TODO 先进行金额校验  不能低于最低配置
        result = amountCheck(redBagType,money,num);
        if (result.isSuccess() == false){
            return result;
        }
        //TODO LUCK - 拼手气【金额随机拆分num 支付时金额直接转换为分】; GENERAL - 普通【金额为单个红包金额 支付时需要乘以个数然后转换为分】
        if (RedBagConfig.REDBAG_TYPE_LUCK.equals(type)){
            money = money.multiply(BigDecimal.valueOf(RedBagConfig.REDBAG_AMOUNT_UNIT));
        }else {
            money = money.multiply(BigDecimal.valueOf(RedBagConfig.REDBAG_AMOUNT_UNIT)).multiply(BigDecimal.valueOf(num));
        }
        //TODO 微信支付方式  调用接口不同：统一下单  或 H5支付  待完善……
        String resultCode = "0";
        if (RedBagConfig.REDBAG_PAYTYPE_IOS.equals(payType) || RedBagConfig.REDBAG_PAYTYPE_ANDROID.equals(payType)){
            result = weChatDefrayService.weChatUniformOrder(GlobalEnums.WECHAT_PAY_BODY.WECHAT_PAY_BODY_RED.getPayDesc(),money, redBag.getOpenid(),GlobalEnums.WECHAT_PAY_BODY.WECHAT_PAY_BODY_RED.getPaySymbol(), redBag.getId());
            resultCode = String.valueOf(result.getMsgCode());
        }else {
            SortedMap<String, Object> sortedMap = weChatDefrayService.weChatDefray(request, money.intValue(), redBag.getOpenid(), redBag.getId(),GlobalEnums.WECHAT_PAY_BODY.WECHAT_PAY_BODY_RED.getPayDesc(), payType);
            resultCode = (String) sortedMap.get("resultCode");
            result.setData(sortedMap);
        }
        //TODO 支付返回成功【并非真的成功 此时插入红包数据 状态待支付 由回调更新支付状态】 否则发红包失败
        if (GlobalEnums.API_SUCCESS_CODE.getMsgCode().equals(resultCode)){
            result.setMsg("发红包[" + GlobalEnums.API_SUCCESS_CODE.getMessage() + "]");
            //TODO 插入红包数据 待完善……
            saveRedBag(account,weChat,redBag,imgs,video);
        }else {
            result.setError("发红包[" + GlobalEnums.API_FAIL_CODE.getMessage() + "]");
        }
        return result;
    }
    /**
     * @MethodName:  amountCheck
     * @Param:       [redBagType, money, num]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:23
     * @Description: TODO               校验红包单个红包金额是否低于系统配置
     */
    private static APIResult amountCheck(RedBagType redBagType,BigDecimal money,Integer num) {
        APIResult result = new APIResult();
        String typeCode = redBagType.getTypeCode();
        String typeName = redBagType.getTypeName();
        BigDecimal minMoney = redBagType.getMinMoney();
        //TODO 拼手气、普通红包最低金额校验
        if (RedBagConfig.REDBAG_TYPE_LUCK.equals(typeCode)){
            BigDecimal minLuckMoney = money.divide(BigDecimal.valueOf(num), 3, BigDecimal.ROUND_HALF_UP);
            if (minLuckMoney.compareTo(minMoney) == -1){
                result.setError(typeName + "平均金额不能低于[" + minMoney + "元]");
            }
        }else {
            if (money.compareTo(minMoney) == -1){
                result.setError(typeName + "单个金额不能低于[" + minMoney + "元]");
            }
        }
        return result;
    }
    /**
     * @MethodName:  saveRedBag
     * @Param:       [account, weChat, redBag, imgs, video]
     * @Return:      java.lang.String
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:22
     * @Description: TODO               保存红包记录
     */
    private String saveRedBag(Account account,WeChat weChat, RedBag redBag, String imgs, String video) {
        redBag.setAccountId(account.getId());
        redBag.setNickName(weChat.getNickName());
        redBag.setTelephone(account.getTelephone());
        redBag.setHeadPortrait(weChat.getHeadPture());
        redBag.setSendTime(DateUtils.getDateTime());
        redBag.setCreateDate(DateUtils.getDateTime());
        redBag.setUnclaimed(redBag.getNum());
        redBag.setAlreadyTake(0);
        redBag.setPayState(-1);
        int i = redBagMapper.insertSelective(redBag);
        return redBag.getId();
    }
}
