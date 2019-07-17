package com.panguaxe.sky.land.service.impl;

import com.panguaxe.sky.common.TkBaseMapper;
import com.panguaxe.sky.land.service.IBaseService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @Title BaseServiceImpl
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/6/3 11:02
 **/
public abstract class BaseService<T> implements IBaseService<T> {

    private static final Logger log = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    protected TkBaseMapper<T> mapper;
    private Class<T> modelClass;

    public BaseService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.modelClass = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(T model) {
        this.mapper.insertSelective(model);
    }

    @Override
    public void deleteById(String id) {
        this.mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(String ids) {

        this.mapper.deleteByIds(ids);
    }

    @Override
    public void update(T model) {
        this.mapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public T findById(String id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = this.modelClass.newInstance();
            Field field = this.modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return this.mapper.selectOne(model);
        } catch (ReflectiveOperationException var5) {
            log.info("BaseService根据属性查询对象异常：{}",var5.getMessage());
        }
        return null;
    }

    @Override
    public List<T> findByIds(String ids) {
        return this.mapper.selectByIds(ids);
    }

    @Override
    public List<T> findAll() {
        return this.mapper.selectAll();
    }
}
