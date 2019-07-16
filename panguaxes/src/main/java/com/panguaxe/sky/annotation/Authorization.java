package com.panguaxe.sky.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 作者 : Panguaxe
 * @Description //TODO 
 * @Date: 2019年07月12日 11:39
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {

    /**接口是否需认证,true:需要;false:不需要*/
    boolean auth() default true;
}
