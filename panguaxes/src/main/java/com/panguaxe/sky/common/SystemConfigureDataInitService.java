package com.panguaxe.sky.common;

import com.panguaxe.sky.land.model.SystemConfigure;
import com.panguaxe.sky.land.service.ISystemConfigureService;
import com.panguaxe.sky.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Title SystemConfigureDataInitService
 * @Description // TODO
 * @Author 作者：Mike Cium
 * @Version: 1.0
 * @Date 2019/6/5 11:15
 **/
@Service
public class SystemConfigureDataInitService implements InitializingBean, ServletContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SystemConfigureDataInitService.class);
    /**map容器*/
    public static Map<String, String> getValByKey = new ConcurrentHashMap<>();

    @Autowired
    private ISystemConfigureService systemConfigureService;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        long startTime = System.currentTimeMillis();
        logger.info("---------------------------------系统配置信息初始化开始-------------------------------------");
        List<SystemConfigure> dataInits = systemConfigureService.findAll();
        if(dataInits != null && !dataInits.isEmpty()){
            for (SystemConfigure systemConfig : dataInits){
                getValByKey.put(systemConfig.getConfigName(),systemConfig.getConfigValue());
                logger.info("配置名 ：{} ------ 配置值 ：{} ",systemConfig.getConfigName(),systemConfig.getConfigValue());
            }
        }
        logger.info("---------------------------------系统配置信息初始化结束：" + (System.currentTimeMillis()-startTime) + " 秒-------------------------------------");
    }

    /**
     * @Author 作者 : Ascetic Monk
     * @Description //TODO              根据键取值
     * @Date: 2019年06月05日 11:50
     * @param configKey             键名
     * @return java.lang.String
     **/
    public String getConfigValByKey(String configKey) {
        String configValue = getValByKey.get(configKey);
        if(ObjectUtils.isEmpty(configValue)) {
            SystemConfigure dataInit = systemConfigureService.findBy("configName", configKey);
            if(ObjectUtils.isNotEmpty(dataInit)) {
                configValue = dataInit.getConfigValue();//配置value
                getValByKey.put(dataInit.getConfigName(), dataInit.getConfigValue());
            }
        }
        return configValue;
    }
}
