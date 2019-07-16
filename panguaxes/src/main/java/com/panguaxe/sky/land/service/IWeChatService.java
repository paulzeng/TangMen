package com.panguaxe.sky.land.service;

import com.panguaxe.sky.land.model.WeChat;

public interface IWeChatService extends IBaseService<WeChat>{

    WeChat findWeChatByTelOrAccount(String accountId,String mobile);
}
