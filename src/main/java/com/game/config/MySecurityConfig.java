package com.game.config;

import com.game.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    // 使用构造函数注入
    private final MyUserDetailsServiceImpl userDetailsService;
    private final MyPasswordEncoder passwordEncoder;

    // 通过构造函数注入依赖
    public MySecurityConfig(MyUserDetailsServiceImpl userDetailsService, MyPasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

//    @Bean
//    public My00LoginAuthenticationProvider my01LoginAuthenticationProvider() {
//        return new My00LoginAuthenticationProvider(userDetailsService, passwordEncoder);
//    }
    @Bean
    public My01JwtAuthenticationFilter my02JwtAuthenticationFilter() throws Exception {
        return new My01JwtAuthenticationFilter();
    }
//    @Bean
//    public My03JwtAuthenticationEntryPoint my03JwtAuthenticationEntryPoint() {
//        return new My03JwtAuthenticationEntryPoint();
//    }
    @Bean
    public My04LoginSuccessHandler my04LoginSuccessHandler() {
        return new My04LoginSuccessHandler();
    }
    @Bean
    public My04LoginFailureHandler my04LoginFailureHandler() {
        return new My04LoginFailureHandler();
    }


    private static final String[] URL_WHITELIST = {
            "/login",         //登录
            "/logout",        //登出
            "/captcha",        //验证码
            "/user/register", //注册
            "/favicon.ico"
    };


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(my02JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin(form -> form
                        .usernameParameter("utel").passwordParameter("upsw")
                        .successHandler(my04LoginSuccessHandler())
                        .failureHandler(my04LoginFailureHandler())
//                        .defaultSuccessUrl("http://localhost:5173/")
//                        .failureUrl("http://localhost:5173/login?err=fail")
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(URL_WHITELIST).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
