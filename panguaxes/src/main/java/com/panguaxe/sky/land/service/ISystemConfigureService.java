package com.panguaxe.sky.land.service;

import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.land.model.SystemConfigure;

/**
 * @Description TODO :
 * @Author ：Panguaxe
 * @Date 2019/7/14 13:52
 * @Version V1.0
 */
public interface ISystemConfigureService extends IBaseService<SystemConfigure>{

    /**
     * @MethodName:  preloadingConfigUpdate
     * @Param:       [configKey, configVal]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/14 13:54
     * @Description: TODO               更新预加载配置
     */
    APIResult preloadingConfigUpdate(String configKey, String configVal);
}
