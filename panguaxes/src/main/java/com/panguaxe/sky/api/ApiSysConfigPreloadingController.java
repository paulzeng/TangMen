package com.panguaxe.sky.api;

import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.land.service.ISystemConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title ApiSysConfigPreloadingController
 * @Description // TODO
 * @Author 作者：Mike Cium
 * @Version: 1.0
 * @Date 2019/6/5 12:49
 **/
@RestController
@RequestMapping("/api/")
public class ApiSysConfigPreloadingController {

    @Autowired
    private ISystemConfigureService systemConfigureService;

    /**
     * @Author 作者 : Ascetic Monk
     * @Description //TODO              更新系统配置预加载数据
     * @Date: 2019年06月05日 16:34
     * @param configKey     键名
     * @param configVal     键值
     * @return com.panguaxe.axe.common.APIResult
     **/
    @RequestMapping("preloadingConfigUpdate.axe")
    public APIResult preloadingConfigUpdate(String configKey, String configVal){
        APIResult result = new APIResult();
        try {
            result = systemConfigureService.preloadingConfigUpdate(configKey,configVal);
        } catch (Exception e) {
            result.setData(e.getMessage());
            result.setError(GlobalEnums.API_NETWORK_ANOMALY.getMessage());
        }
        return result;
    }
}
