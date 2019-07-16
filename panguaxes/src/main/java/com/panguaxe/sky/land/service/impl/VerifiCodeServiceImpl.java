package com.panguaxe.sky.land.service.impl;

import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.land.mapper.VerifiCodeMapper;
import com.panguaxe.sky.land.model.VerifiCode;
import com.panguaxe.sky.land.service.IVerifiCodeService;
import com.panguaxe.sky.utils.ObjectUtils;
import com.panguaxe.sky.utils.date.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Title VerifiCodeServiceImpl
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/13 10:51
 **/
@Service
public class VerifiCodeServiceImpl extends BaseService<VerifiCode> implements IVerifiCodeService {

    @Autowired
    private VerifiCodeMapper verifiCodeMapper;

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          校验验证码
     * @Date: 2019年07月13日 10:54
     * @param telephone     手机号
     * @param smsCode       验证码
     * @param smsSort       短信分类: 1 注册; 2 验证码登陆；……
     * @return VerifiCode
     **/
    @Override
    public VerifiCode checkVerifiCode(String telephone, String smsCode, Integer smsSort) {
        if (ObjectUtils.isEmpty(telephone) || smsSort == null){
            return null;
        }
        Example example = new Example(VerifiCode.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("telephone",telephone);
        if (ObjectUtils.isNotEmpty(smsCode)){
            criteria.andEqualTo("smsCode",smsCode);
        }
        criteria.andEqualTo("smsSort",smsSort);
        return verifiCodeMapper.selectOneByExample(example);
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          获取验证码
     * @Date: 2019年07月13日 11:02
     * @param telephone     手机号
     * @param smsSort       短信分类: 1 注册; 2 验证码登陆；……
     * @return APIResult
     **/
    @Override
    public APIResult generateSmsCode(String telephone, Integer smsSort) {
        APIResult result = new APIResult();
        if (ObjectUtils.isEmpty(telephone) || smsSort == null){
            return result.setError("请输入您的手机号……");
        }
        //TODO 获取4位验证码
        String smsCode = ObjectUtils.smsCodeGenerator();
        checkVerifiCode(telephone,null,smsSort);
        VerifiCode verifiCode = checkVerifiCode(telephone, null, smsSort);
        //TODO 如果是空 插入数据  否则更新验证码
        int i = 0 ;
        result.setMsg("获取验证码【" + GlobalEnums.API_SUCCESS_CODE.getMessage() + "】");
        if (ObjectUtils.isEmpty(verifiCode)){
            verifiCode = new VerifiCode();
            verifiCode.setTelephone(telephone);
            verifiCode.setSmsCode(smsCode);
            verifiCode.setSmsSort(smsSort);
            verifiCode.setValidTime(2);
            verifiCode.setCreateDate(DateUtils.getDateTime());
            i = verifiCodeMapper.insertSelective(verifiCode);
            if (i != 1){
                result.setError("获取验证码【" + GlobalEnums.API_FAIL_CODE.getMessage() + "】");
            }
        }else {
            verifiCode.setSmsCode(smsCode);
            verifiCode.setUpdateDate(DateUtils.getDateTime());
            i = verifiCodeMapper.updateByPrimaryKeySelective(verifiCode);
            if (i != 1){
                result.setError("获取验证码【" + GlobalEnums.API_FAIL_CODE.getMessage() + "】");
            }
        }
        result.setData(smsCode);
        return result;
    }

}
