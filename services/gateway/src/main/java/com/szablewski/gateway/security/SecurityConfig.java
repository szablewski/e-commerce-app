package com.szablewski.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http
//                .csrf(ServerHttpSecurity.CsrfSpec::disable)
//                .authorizeExchange(exchange -> exchange
//                        .pathMatchers("(/eureka/**")
//                        .permitAll()
//                        .anyExchange()
//                        .authenticated()
//                )
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
//        return http.build();
//    }
//}
