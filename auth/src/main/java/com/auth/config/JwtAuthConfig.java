
package com.auth.config;

import com.model.entity.SysUser;
import common.utils.JwtTokenUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class JwtAuthConfig {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserDetailsService userDetailsService;

    //登录认证换取token令牌
    public String login(SysUser sysUser, HttpServletResponse response) {
        //UsernamePasswordAuthenticationToken：基于用户名和密码的身份验证过滤器
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(sysUser.getUsername(),sysUser.getPassword());

        Authentication authenticate = authenticationManager.authenticate(upToken);
        //验证通过用户放入security上下文中
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        // 使用用户名加载用户信息
        //UserDetails userDetails = this.userDetailsService.loadUserByUsername(sysUser.getUsername());


        String token = JwtTokenUtils.generateToken(sysUser);

        //设置token到header中
        response.addHeader("Authorization", "Bearer " + token);

        // 生成token
        return token;
    }


    //刷新token

    public String refreshToken(String oldToken, HttpServletResponse response) {

        // 获取真正token
        String token = JwtTokenUtils.realToken(oldToken);

        // 判断token是否过期
        if (JwtTokenUtils.isTokenExpired(token)) {
            return null;
        }else {
            // 刷新令牌
            String refreshToken = JwtTokenUtils.refreshToken(token);
            response.addHeader("Authorization", "Bearer " + refreshToken);
            return refreshToken;
        }
    }
}
