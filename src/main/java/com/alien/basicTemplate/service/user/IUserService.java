package com.alien.basicTemplate.service.user;

import com.alien.basicTemplate.entity.SysUser;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 09:26
 * @Description:
 */
public interface IUserService {
    SysUser findUserByUsername(String username);
}
