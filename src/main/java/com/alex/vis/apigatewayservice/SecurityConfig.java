package com.alex.vis.apigatewayservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
//Enable security module in project
@EnableWebFlux
public class SecurityConfig {

    //All incoming requests should be authenticated by our oauth 2.0 provider
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
                .oauth2Login(Customizer.withDefaults());

        http.csrf().disable();
        return http.build();
    }

    //определяем product service как resource сервер
}