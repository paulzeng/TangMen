package com.panguaxe.sky.land.service.impl;

import com.panguaxe.sky.land.mapper.IdentifyMapper;
import com.panguaxe.sky.land.model.Identify;
import com.panguaxe.sky.land.service.IIdentifyService;
import com.panguaxe.sky.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Title IdentifyServiceImpl
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 10:59
 **/
@Service
public class IdentifyServiceImpl extends BaseService<Identify> implements IIdentifyService {

    @Autowired
    private IdentifyMapper identifyMapper;
    /**
     * @MethodName:  findIdentifyByAccount
     * @Param:       [accountId]
     * @Return:      com.panguaxe.sky.land.model.Identify
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:28
     * @Description: TODO           根据账号ID 查询实名信息
     */
    @Override
    public Identify findIdentifyByAccount(String accountId) {
        if (ObjectUtils.isEmpty(accountId)){
            return null;
        }
        return findBy("accountId",accountId);
    }
    /**
     * @MethodName:  findIdentifyByIDCard
     * @Param:       [idCard]
     * @Return:      java.util.List<com.panguaxe.sky.land.model.Identify>
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:28
     * @Description: TODO           根据身份证号 查询该用户身份证号几个账户信息 、 实名信息
     */
    @Override
    public List<Identify> findIdentifyByIDCard(String idCard) {
        if (ObjectUtils.isEmpty(idCard)){
            return null;
        }
        Example example = new Example(Identify.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("idCard",idCard);
        return identifyMapper.selectByExample(example);
    }
}
