package com.alien.basicTemplate.aspect;

import com.alien.basicTemplate.entity.Role;
import com.alien.basicTemplate.entity.SysUser;
import com.alien.basicTemplate.model.annotation.Perms;
import com.alien.basicTemplate.utils.UserUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Auther: FengYunJun
 * @Date: 2019/1/22 14:46
 * @Description:
 */
@Aspect
@Component
public class PermsAspect {

    //定义切点
    @Pointcut("@annotation(com.alien.basicTemplate.model.annotation.Perms)")
    public void permsPointCut() {

    }

    //第一个通配符匹配所有返回值类型，第二个匹配这个类里的所有方法，（）括号表示参数列表，括号里的用两个点号表示匹配任意个参数，包括0个
    @Pointcut("execution( * com.alien.basicTemplate.controller.api.*(..))")
    public void TestPointCut() {

    }

    @Around("permsPointCut()")
    public Object isAccessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();//获取方法签名
        Method method = methodSignature.getMethod();
        Perms perms = method.getAnnotation(Perms.class);
        if (perms == null) {
            return joinPoint.proceed();
        } else {
            String[] roles = perms.role().split(",");
            //获取当前用户的
            SysUser user = UserUtils.getConCurrentUser();
            List<Role> list = (List<Role>) user.getAuthorities();
            //todo
        }
        return null;
    }
}
