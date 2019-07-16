package com.panguaxe.sky.land.service.impl;

import com.panguaxe.sky.land.mapper.IncomeTypeMapper;
import com.panguaxe.sky.land.model.IncomeType;
import com.panguaxe.sky.land.service.IIncomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Title IncomeTypeServiceImpl
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 11:11
 **/
@Service
public class IncomeTypeServiceImpl extends BaseService<IncomeType> implements IIncomeTypeService {

    @Autowired
    private IncomeTypeMapper incomeTypeMapper;
    /**
     * @MethodName:  findByIncomeType
     * @Param:       [incomeType]
     * @Return:      com.panguaxe.sky.land.model.IncomeType
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:29
     * @Description: TODO           根据收益类型 获取收益配置信息
     */
    @Override
    public IncomeType findByIncomeType(Integer incomeType) {
        if (null == incomeType){
            return null;
        }
        Example example = new Example(IncomeType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("incomeType",incomeType);
        criteria.andEqualTo("state",1);
        return incomeTypeMapper.selectOneByExample(example);
    }
}
