package com.panguaxe.sky.common;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author 作者 : Panguaxe
 * @Description //TODO                  通用mapper
 * @Date: 2019年06月05日 15:27
 **/
public interface TkBaseMapper <T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T>,
        ConditionMapper<T> {
}
