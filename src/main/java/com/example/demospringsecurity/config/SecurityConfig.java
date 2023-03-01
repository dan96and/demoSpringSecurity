package com.example.demospringsecurity.config;


import com.example.demospringsecurity.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.demospringsecurity.core.Constants.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsServiceImpl userDetailsService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and().build();
    }

    @Bean
    public SecurityFilterChain configureMvcSecurity(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                authorizeRequest ->
                {
                    try {
                        authorizeRequest.requestMatchers(LOGIN_URL).permitAll()
                                .requestMatchers("/home").permitAll()
                                .requestMatchers("/new-user").permitAll()
                                .requestMatchers("/home/screenUser").hasRole(USER_ROLE)
                                .requestMatchers("/home/screenAdmin").hasRole(ADMIN_ROLE)
                                .anyRequest().authenticated().and().csrf().disable()
                                .formLogin()
                                .loginPage(LOGIN_URL)
                                .defaultSuccessUrl(LOGIN_SUCCESS_URL)
                                .failureUrl(LOGIN_FAILURE_URL);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        ).build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
