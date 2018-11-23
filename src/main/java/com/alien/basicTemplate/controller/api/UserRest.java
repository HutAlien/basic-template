package com.alien.basicTemplate.controller.api;

import com.alien.basicTemplate.controller.AbstractController;
import com.alien.basicTemplate.dto.AjaxResult;
import com.alien.basicTemplate.entity.User;
import com.alien.basicTemplate.utils.UserUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 10:27
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class UserRest extends AbstractController {

    @PostMapping("/login")
    public void login() {
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('admin')")   //若权限点字符串为"ROLE_ADMIN" 则hasAuthority('ROLE_ADMIN')或hasRole('ADMIN')
    public boolean IsAuthenticated() {
        return UserUtils.getAuthentication().isAuthenticated();
    }
}
