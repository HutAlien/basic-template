package com.alien.basicTemplate.entity;

import lombok.Data;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User implements UserDetails,Serializable{
    @Id
    private Integer id;
    private String username;
    private String password;
    @ManyMany(relation = "bt_user_role",from = "user_id:id",to = "role_id:id")
    private List<Role> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
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
