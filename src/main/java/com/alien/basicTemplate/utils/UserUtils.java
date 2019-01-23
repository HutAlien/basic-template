package com.alien.basicTemplate.utils;

import com.alien.basicTemplate.model.dto.AjaxCode;
import com.alien.basicTemplate.entity.SysUser;
import com.alien.basicTemplate.exception.CustomException;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 11:14
 * @Description:
 */
public class UserUtils {
    /**
     * 获取当前用户
     *
     * @param
     * @return
     */
    public static SysUser getConCurrentUser() {
        if (getAuthentication() == null || !getAuthentication().isAuthenticated()) {
            throw new CustomException(AjaxCode.LOGIN_INVALID_MESSAGE);
        }
        return (SysUser) getAuthentication().getPrincipal();
    }

    /**
     * 获取当前用户认证信息
     *
     * @param
     * @return
     */
    public static org.springframework.security.core.Authentication getAuthentication() {
        //通过security上下文来获取认证信息   而SecurityContextHolder()用于获取Security上下文
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new CustomException(AjaxCode.LOGIN_INVALID_MESSAGE);
        }
        return authentication;
    }
}
