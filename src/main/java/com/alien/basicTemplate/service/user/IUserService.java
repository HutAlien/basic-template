package com.alien.basicTemplate.service.user;

import com.alien.basicTemplate.entity.User;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 09:26
 * @Description:
 */
public interface IUserService {
    User findUserByUsername(String username);
}
