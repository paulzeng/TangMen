package com.panguaxe.sky.land.service;

import com.panguaxe.sky.land.model.Identify;

import java.util.List;

public interface IIdentifyService extends IBaseService<Identify>{

    Identify findIdentifyByAccount(String accountId);

    List<Identify> findIdentifyByIDCard(String idCard);
}
