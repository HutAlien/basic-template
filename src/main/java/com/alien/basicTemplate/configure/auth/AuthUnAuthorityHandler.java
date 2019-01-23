package com.alien.basicTemplate.configure.auth;

import com.alien.basicTemplate.model.dto.AjaxCode;
import com.alien.basicTemplate.model.dto.AjaxResult;
import org.nutz.json.Json;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 14:24
 * @Description: 无权访问处理
 */
public class AuthUnAuthorityHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(Json.toJson(new AjaxResult(AjaxCode.FAILURE, "权限不足")));
    }
}
