package com.alien.basicTemplate.service.user.impl;

import com.alien.basicTemplate.entity.SysUser;
import com.alien.basicTemplate.service.user.IUserService;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 09:48
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    Dao dao;

    @Override
    public SysUser findUserByUsername(String username) {
        SysUser user =dao.fetchLinks(dao.fetch(SysUser.class, Cnd.where("username","=",username)),"authorities");
        if (user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
