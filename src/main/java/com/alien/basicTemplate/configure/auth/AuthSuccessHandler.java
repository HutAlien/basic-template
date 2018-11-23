package com.alien.basicTemplate.configure.auth;

import com.alien.basicTemplate.dto.AjaxCode;
import com.alien.basicTemplate.dto.AjaxResult;
import com.alien.basicTemplate.utils.UserUtils;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
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
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private Logger logger= LoggerFactory.getLogger(AuthSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
       // super.onAuthenticationSuccess(request, response, authentication);
        logger.info("登录成功");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(Json.toJson(new AjaxResult(AjaxCode.SUCCESS, AjaxCode.SUCCESS_MESSAGE, UserUtils.getConCurrentUser())));
    }
}
