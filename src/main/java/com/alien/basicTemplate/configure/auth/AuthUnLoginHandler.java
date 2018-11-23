package com.alien.basicTemplate.configure.auth;

import com.alien.basicTemplate.dto.AjaxCode;
import com.alien.basicTemplate.dto.AjaxResult;
import org.nutz.json.Json;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 14:17
 * @Description: 未登录 登录失效处理
 */
@Component
public class AuthUnLoginHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(Json.toJson(new AjaxResult(AjaxCode.FAILURE,"登录已失效")));
    }
}
