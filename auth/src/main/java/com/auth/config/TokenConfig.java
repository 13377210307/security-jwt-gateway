/*package com.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    //使用jwt 管理token
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        // 签名密钥
        accessTokenConverter.setSigningKey("oauth2");
        DefaultAccessTokenConverter defaultAccessTokenConverter=new DefaultAccessTokenConverter();
        accessTokenConverter.setAccessTokenConverter(defaultAccessTokenConverter);
        return accessTokenConverter;
    }
}*/
