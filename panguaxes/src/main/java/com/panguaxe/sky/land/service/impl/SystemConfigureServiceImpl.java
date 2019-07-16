package com.panguaxe.sky.land.service.impl;

import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.common.SystemConfigureDataInitService;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.land.mapper.SystemConfigureMapper;
import com.panguaxe.sky.land.model.SystemConfigure;
import com.panguaxe.sky.land.service.ISystemConfigureService;
import com.panguaxe.sky.utils.ObjectUtils;
import com.panguaxe.sky.utils.date.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SystemConfigureServiceImpl
 * @Description TODO :
 * @Author ：Panguaxe
 * @Date 2019/7/14 13:53
 * @Version V1.0
 */
@Slf4j
@Service
public class SystemConfigureServiceImpl extends BaseService<SystemConfigure> implements ISystemConfigureService {

    @Autowired
    private SystemConfigureMapper systemConfigureMapper;

    /**
     * @MethodName:  preloadingConfigUpdate
     * @Param:       [configKey, configVal]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/14 13:57
     * @Description: TODO               预加载配置更新
     */
    @Override
    public APIResult preloadingConfigUpdate(String configKey, String configVal) {
        APIResult result = new APIResult();
        if(ObjectUtils.isEmpty(configVal)) return result.setError("请输入修改配置的value");
        if(ObjectUtils.isEmpty(configKey)) return result.setError("请输入修改配置的key");
        SystemConfigure dataInit = findBy("configName", configKey);
        String val = SystemConfigureDataInitService.getValByKey.get(configKey);
        log.info("缓存中的值：{}",val);
        log.info("配置记录对象：{}",dataInit.toString());
        log.info("键名：{} ------ 键值：{}",configKey,configVal);
        dataInit.setConfigValue(configVal);
        dataInit.setUpdateDate(DateUtils.getDateTime());
        int i = systemConfigureMapper.updateByPrimaryKeySelective(dataInit);
        result.setError(GlobalEnums.API_FAIL_CODE.getMessage());
        if (i == 1){
            result.setMsg(GlobalEnums.API_SUCCESS_CODE.getMessage());
            //将新值放到缓存中
            SystemConfigureDataInitService.getValByKey.put(configKey,configVal);
        }
        return result;
    }
}
