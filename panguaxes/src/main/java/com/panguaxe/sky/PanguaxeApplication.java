package com.panguaxe.sky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * @Author 作者：Panguaxe
 * @Desc	TODO
 * @date 2019-07-12
 */
@SpringBootApplication
/**TODO 开启定时任务*/
@EnableScheduling
@MapperScan(basePackages = "com.panguaxe.sky.land.mapper")
public class PanguaxeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PanguaxeApplication.class, args);
    }

}
