package com.getarrays.userservice.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.stereotype.Component;

import com.getarrays.userservice.filter.JwtAuthenticationFilter;

@Component
public class JWTHttpConfigurer  extends AbstractHttpConfigurer<JWTHttpConfigurer, HttpSecurity> {
    
    @Override
    public void configure(HttpSecurity http)  throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        JwtAuthenticationFilter jwtAuthorizationFilter = new JwtAuthenticationFilter(authenticationManager);
        jwtAuthorizationFilter.setFilterProcessesUrl("/api/login");
        http.addFilter(jwtAuthorizationFilter);
    }

    public static JWTHttpConfigurer jWTHttpConfigurer() {
        return new JWTHttpConfigurer();
    }
}
