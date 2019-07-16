package com.panguaxe.sky.land.service.impl;

import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.land.mapper.AccountMapper;
import com.panguaxe.sky.land.model.Account;
import com.panguaxe.sky.land.model.Identify;
import com.panguaxe.sky.land.model.VerifiCode;
import com.panguaxe.sky.land.model.WeChat;
import com.panguaxe.sky.land.service.IAccountService;
import com.panguaxe.sky.land.service.IIdentifyService;
import com.panguaxe.sky.land.service.IVerifiCodeService;
import com.panguaxe.sky.land.service.IWeChatService;
import com.panguaxe.sky.utils.JWTUtil;
import com.panguaxe.sky.utils.ObjectUtils;
import com.panguaxe.sky.utils.date.DateUtils;
import com.panguaxe.sky.utils.safe.PasswordSafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title AccountServiceImpl
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 10:39
 **/
@Service
public class AccountServiceImpl extends BaseService<Account> implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private IIdentifyService identifyService;
    @Autowired
    private IWeChatService weChatService;
    @Autowired
    private IVerifiCodeService verifiCodeService;
    
    /**
     * @MethodName:  accountLogin
     * @Param:       [request, userName, password]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:25
     * @Description: TODO               用户登录【账号、密码】
     */
    @Override
    public APIResult accountLogin(HttpServletRequest request, String userName, String password) {
        APIResult result = new APIResult();
        Account account = findAccountByTelOrUsername(userName, userName);
        if(ObjectUtils.isEmpty(account)){
            return result.setError("请确认您的用户名![" + userName + "用户信息不存在]");
        }
        //TODO 校验密码是否正确
        boolean b = PasswordSafeUtils.checkPassword(userName, password, account.getSalt(), account.getPassword());
        if (b){
            WeChat weChat = weChatService.findWeChatByTelOrAccount(account.getId(), account.getTelephone());
            account.setLastLogin(DateUtils.getDateTime());
            accountMapper.updateByPrimaryKeySelective(account);
            result.setMsg("登录成功");
            result.setData(getAccountInfo(account,weChat));
        }else {
            result.setError("密码错误! 请重新输入!【👻是否找回密码?】");
        }
        return result;
    }
    /**
     * @MethodName:  accountLogon
     * @Param:       [telephone, smsCode]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:45
     * @Description: TODO               账号注册【手机号注册】
     */
    @Override
    public APIResult accountLogon(String telephone, String smsCode,Integer gender) {
        APIResult result = new APIResult();
        Account account = findAccountByTelOrUsername(telephone, telephone);
        if (ObjectUtils.isNotEmpty(account)){
            return result.setError("该手机号已注册[是否找回密码？]");
        }
        //TODO 校验验证码 待建表 待完善……
        VerifiCode verifiCode = verifiCodeService.checkVerifiCode(telephone, smsCode, 1);
        if (ObjectUtils.isEmpty(verifiCode)){
            return result.setError("注册失败【失败原因：验证码校验失败!】");
        }
        LocalDateTime dateTime = DateUtils.toLocalDateTime(verifiCode.getCreateDate()).plusMinutes(verifiCode.getValidTime());
        if(DateUtils.getLocalDateTime().isAfter(dateTime)){
            return result.setError("注册失败【失败原因：验证码失效】");
        }
        if(!smsCode.equals(verifiCode.getSmsCode())){
            return result.setError("验证码错误,请重新输入");
        }
        account = new Account();
        account.setUserName(telephone);
        account.setNickName(telephone);
        account.setTelephone(telephone);
        String salt = PasswordSafeUtils.getPasswordSalt();
        String encryPwd = PasswordSafeUtils.getEncryptPassword(telephone, "888888", salt);
        account.setPassword(encryPwd);
        account.setSalt(salt);
        account.setGender(gender);
        account.setLastLogin(DateUtils.getDateTime());
        account.setCreateDate(DateUtils.getDateTime());
        int i = accountMapper.insertSelective(account);
        if (i == 1){
            Map<String, Object> map = getAccountInfo(account, null);
            result.setData(map);
            result.setMsg("账号注册[手机号注册]【" + GlobalEnums.API_SUCCESS_CODE.getMessage() + "】");
        }else {
            result.setError("账号注册[手机号注册]【" + GlobalEnums.API_FAIL_CODE.getMessage() + "】");
        }
        return result;
    }

    /**
     * @MethodName:  getAccountInfo
     * @Param:       [account, weChat]
     * @Return:      java.util.Map<java.lang.String,java.lang.Object>
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:26
     * @Description: TODO               登录成功后返回前端用户相关必要参数
     */
    private Map<String,Object> getAccountInfo(Account account,WeChat weChat){
        Map<String,Object> map = new HashMap<>();
        map.clear();
        Identify identify = identifyService.findIdentifyByAccount(account.getId());
        map.put("token",account.getId());
        map.put("jToken",JWTUtil.sign(account.getTelephone(),account.getPassword()));
        map.put("nickName",account.getUserName());
        map.put("mobile",account.getTelephone());
        map.put("isPass",0);
        if (ObjectUtils.isNotEmpty(identify)){
            map.put("isPass",identify.getIsPass());
            map.put("cardNo",identify.getIdCard());
        }
        if (ObjectUtils.isNotEmpty(weChat)){
            map.put("openid",weChat.getOpenid());
            map.put("nickName",weChat.getNickName());
            map.put("headPture",weChat.getHeadPture());
        }
        return map;
    }

    /**
     * @MethodName:  findAccountByTelOrUsername
     * @Param:       [userName, telephone]
     * @Return:      com.panguaxe.sky.land.model.Account
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:27
     * @Description: TODO           根据手机号或者用户名查询用户信息
     */
    @Override
    public Account findAccountByTelOrUsername(String userName, String telephone) {
        if (ObjectUtils.isEmpty(userName) && ObjectUtils.isEmpty(telephone)){
            return null;
        }
        Example example = new Example(Account.class);
        Example.Criteria criteria = example.createCriteria();
        //TODO 走到这 说明用户名、手机号至少一个不是空   如果手机号是空  用户名肯定不为空
        if (ObjectUtils.isEmpty(telephone)){
            criteria.andEqualTo("userName",userName);
        }else {
            criteria.andEqualTo("telephone",telephone);
        }
        return accountMapper.selectOneByExample(example);
    }


}
