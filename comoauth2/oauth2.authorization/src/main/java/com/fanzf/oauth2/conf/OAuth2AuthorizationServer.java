package com.fanzf.oauth2.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author
 * @create 2019 10 22 22:05
 */
//授权服务器配置
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer  extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {

        String finalSecret = "{bcrypt}"+new BCryptPasswordEncoder().encode("123456");

        clients.inMemory()

                .withClient("client_1")
                .secret(finalSecret)
                .redirectUris("http://localhost:9001/callback")
                // 授权码模式
                .authorizedGrantTypes("authorization_code")
                .scopes("read_userinfo", "read_contacts");
    }


}
