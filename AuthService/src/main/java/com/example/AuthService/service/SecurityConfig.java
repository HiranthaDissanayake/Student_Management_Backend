package com.example.AuthService.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // CSRF ආරක්ෂාව අක්‍රිය කරන්න
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // '/auth' වලින් පටන් ගන්නා සියල්ලට අවසර දෙන්න
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}