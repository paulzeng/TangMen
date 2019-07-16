package com.panguaxe.sky.land.service;

import org.apache.ibatis.exceptions.TooManyResultsException;

import java.util.List;

public interface IBaseService<T>{

    void save(T var1);

    void deleteById(String var1);

    void deleteByIds(String var1);

    void update(T var1);

    T findById(String var1);

    T findBy(String var1, Object var2) throws TooManyResultsException;

    List<T> findByIds(String var1);

    List<T> findAll();
}
