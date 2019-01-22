package com.alien.basicTemplate.configure;

import com.alien.basicTemplate.configure.auth.AuthFailureHandler;
import com.alien.basicTemplate.configure.auth.AuthSuccessHandler;
import com.alien.basicTemplate.configure.auth.AuthUnAuthorityHandler;
import com.alien.basicTemplate.configure.auth.AuthUnLoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 09:19
 * @Description:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigure extends WebSecurityConfigurerAdapter{
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    /**
     * 密码使用明文校验
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }
        };
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/api/user").hasRole("admin")   //匹配器对路径进行权限匹配
                .anyRequest().authenticated()  //任何请求都需要先认证
                .and().formLogin()
                .loginProcessingUrl("/api/login")  //登录URL
                .permitAll()  //登录接口可以匿名访问
                .failureHandler(new AuthFailureHandler())   //登录失败处理(否则为html页面，下同)
                .successHandler(new AuthSuccessHandler())   //登录成功处理
                .and().logout().clearAuthentication(true).deleteCookies("") //登录之后清除认证信息和Cookie
                .and().exceptionHandling().authenticationEntryPoint(new AuthUnLoginHandler())   //登录失效或未认证处理
                .and().csrf().disable();  //关闭跨域请求伪造

        http.exceptionHandling().accessDeniedHandler(new AuthUnAuthorityHandler());  //权限不够处理(否则返回html页面)
    }
}
