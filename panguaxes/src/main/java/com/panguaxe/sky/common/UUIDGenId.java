package com.panguaxe.sky.common;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * @Author 作者 : Panguaxe
 * @Description //TODO              主键UUID生成策略
 * @Date: 2019年06月05日 15:29
 **/
public class UUIDGenId implements GenId<String> {

    @Override
    public String genId(String s, String s1) {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
