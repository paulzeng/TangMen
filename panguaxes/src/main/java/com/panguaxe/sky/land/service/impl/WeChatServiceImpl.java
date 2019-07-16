package com.panguaxe.sky.land.service.impl;

import com.panguaxe.sky.land.mapper.WeChatMapper;
import com.panguaxe.sky.land.model.WeChat;
import com.panguaxe.sky.land.service.IWeChatService;
import com.panguaxe.sky.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Title WeChatServiceImpl
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 10:52
 **/
@Service
public class WeChatServiceImpl extends BaseService<WeChat> implements IWeChatService {

    @Autowired
    private WeChatMapper weChatMapper;

    /**
     * @MethodName:  findWeChatByTelOrAccount
     * @Param:       [accountId, mobile]
     * @Return:      com.panguaxe.sky.land.model.WeChat
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:31
     * @Description: TODO               根据账户ID 或 手机号查询账户微信数据
     */
    @Override
    public WeChat findWeChatByTelOrAccount(String accountId, String mobile) {
        if (ObjectUtils.isEmpty(accountId) && ObjectUtils.isEmpty(mobile)){
            return null;
        }
        Example example = new Example(WeChat.class);
        Example.Criteria criteria = example.createCriteria();
        if (ObjectUtils.isNotEmpty(accountId)){
            criteria.andEqualTo("accountId",accountId);
        }
        if (ObjectUtils.isNotEmpty(mobile)){
            criteria.andEqualTo("mobile",mobile);
        }
        return weChatMapper.selectOneByExample(example);
    }
}
