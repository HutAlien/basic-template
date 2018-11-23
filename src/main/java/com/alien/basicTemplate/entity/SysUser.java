package com.alien.basicTemplate.entity;

import lombok.Data;
import org.nutz.dao.entity.annotation.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 08:54
 * @Description:
 */
@Table("bt_user")
@Data
public class SysUser implements UserDetails,Serializable{
    @Id
    private Integer id;
    @Name
    private String username;
    @Column
    private String password;
    @ManyMany(relation = "bt_user_role",from = "user_id:id",to = "role_id:id")
    private List<Role> authorities;   //权限
    @Column("is_non_locked")
    private boolean isAccountNonLocked;  //账户是否被解锁

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {          //是否过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
