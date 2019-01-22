package com.alien.basicTemplate.configure.auth;

import com.alien.basicTemplate.model.dto.AjaxCode;
import com.alien.basicTemplate.model.dto.AjaxResult;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 11:01
 * @Description:
 */
@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger  logger= LoggerFactory.getLogger(AuthFailureHandler.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败");
        response.setContentType("application/json;charset=UTF-8");
        //失败异常处理
        if (exception instanceof UsernameNotFoundException ||exception instanceof BadCredentialsException) {
            response.getWriter().write(Json.toJson(new AjaxResult(AjaxCode.FAILURE, "用户名或密码错误")));
        } else if (exception instanceof DisabledException) {
            response.getWriter().write(Json.toJson(new AjaxResult(AjaxCode.FAILURE, "用户账号已被锁定")));
        } else {
            response.getWriter().write(Json.toJson(new AjaxResult(AjaxCode.FAILURE, "认证失败")));
        }
    }
}
