package com.alien.basicTemplate.model.annotation;

import java.lang.annotation.*;

/**
 * @Auther: FengYunJun
 * @Date: 2019/1/22 14:53
 * @Description: 自定义权限注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Perms {
    String role() default "";
}
