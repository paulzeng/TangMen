package com.panguaxe.sky.land.service;

import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.land.model.Account;
import com.panguaxe.sky.land.model.RedBag;

import javax.servlet.http.HttpServletRequest;

public interface IRedBagService extends IBaseService<RedBag>{

    APIResult dispenseRedBag(HttpServletRequest request, Account account, RedBag redBag, String imgs, String video);
}
