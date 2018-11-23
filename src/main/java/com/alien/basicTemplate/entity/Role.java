package com.alien.basicTemplate.entity;

import lombok.Data;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 09:00
 * @Description:
 */
@Table("bt_role")
@Data
public class Role implements GrantedAuthority{
    @Id
    private Integer id;
    private String roleName;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
