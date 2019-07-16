package com.panguaxe.sky.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 作者 : Ascetic Monk
 * @Description //TODO          当前用户模型,需配合Autorization注解使用,否则无效且抛出异常
 * @Date: 2019年07月12日 11:40
 **/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {
}
