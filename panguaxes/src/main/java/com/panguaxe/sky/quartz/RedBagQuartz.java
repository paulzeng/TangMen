package com.panguaxe.sky.quartz;

import com.panguaxe.sky.land.service.IRedBagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Title RedBagQuartz
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/13 14:13
 **/
@Slf4j
@Component
public class RedBagQuartz {

    @Autowired
    private IRedBagService redBagService;


    @Scheduled(cron = "0 */9 * * * ?")
    public void redBagReclaim(){
        log.info("----------------------------------------定时任务开始执行----------------------------------------");
    }

}
