/*package com.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenConfig tokenConfig;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;


    // 用来配置令牌访问端点安全策略


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")  // 检测token公开
                .allowFormAuthenticationForClients(); //允许表单验证
    }

    // 配置客户端详情服务，客户端详情信息在此进行初始化，通过数据库存储详细信息


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 使用内存方式
        clients.inMemory()
                .withClient("c1")  // 客户端id
                .secret(new BCryptPasswordEncoder().encode("secret")) // 客户端密钥
                .resourceIds("res1") // 资源列表
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token") // 该client允许授权类型
                .scopes("all")  //允许授权范围
                .autoApprove(false) // false 表示跳到授权页面
                .redirectUris("http://www.baidu.com"); //验证回调地址
    }

    // 配置令牌端点安全约束

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager) // 密码模式需要
                //.authorizationCodeServices(authorizationCodeServices)  // 授权码模式需要
                .userDetailsService(userDetailsService)  // 使用userDetailService
                .tokenServices(tokenServices())  // 令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);  // 允许post提交

    }

    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService);  // 客户端信息服务
        services.setSupportRefreshToken(true);  // 是否产生刷新令牌
        services.setTokenStore(tokenConfig.jwtTokenStore());  // 令牌存储方式
        services.setAccessTokenValiditySeconds(7200); // 令牌过期时间2小时
        services.setRefreshTokenValiditySeconds(259200); // 刷新令牌默认有效时间
        return services;
    }


}*/
