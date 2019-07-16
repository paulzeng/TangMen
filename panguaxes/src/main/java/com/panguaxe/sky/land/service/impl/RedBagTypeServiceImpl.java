package com.panguaxe.sky.land.service.impl;

import com.panguaxe.sky.land.mapper.RedBagTypeMapper;
import com.panguaxe.sky.land.model.RedBagType;
import com.panguaxe.sky.land.service.IRedBagTypeService;
import com.panguaxe.sky.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Title RedBagTypeServiceImpl
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 11:18
 **/
@Service
public class RedBagTypeServiceImpl extends BaseService<RedBagType> implements IRedBagTypeService {

    @Autowired
    private RedBagTypeMapper redBagTypeMapper;

    /**
     * @MethodName:  findByTypeCode
     * @Param:       [typeCode]
     * @Return:      com.panguaxe.sky.land.model.RedBagType
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:31
     * @Description: TODO               根据红包类型 获取红包类型配置信息
     */
    @Override
    public RedBagType findByTypeCode(String typeCode) {
        if (ObjectUtils.isEmpty(typeCode)){
            return null;
        }
        Example example = new Example(RedBagType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("typeCode",typeCode);
        criteria.andEqualTo("state",1);
        return redBagTypeMapper.selectOneByExample(example);
    }
}
