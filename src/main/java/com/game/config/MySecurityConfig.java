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
    public My01JwtAuthenticationFilter my01JwtAuthenticationFilter() throws Exception {
        return new My01JwtAuthenticationFilter();
    }
    @Bean
    public My04JwtAuthenticationEntryPoint my04JwtAuthenticationEntryPoint() {
        return new My04JwtAuthenticationEntryPoint();
    }
    @Bean
    public My04LoginSuccessHandler my04LoginSuccessHandler() {
        return new My04LoginSuccessHandler();
    }
    @Bean
    public My04LoginFailureHandler my04LoginFailureHandler() {
        return new My04LoginFailureHandler();
    }


    private static final String[] URL_WHITELIST = {
            "/register",
            "/login",         //登录
            "/logout",        //登出
            "/captcha",        //验证码
            "/favicon.ico"
    };


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(my01JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)     // 配置自定义JWT认证过滤器
                .formLogin(form -> form
                        .usernameParameter("utel").passwordParameter("upsw")
                        .loginPage("/login")
                        .successHandler(my04LoginSuccessHandler())      // 配置自定义登录成功处理器
                        .failureHandler(my04LoginFailureHandler())      // 配置自定义登录失败处理器
                )
                .exceptionHandling(
                        exception -> exception.authenticationEntryPoint(my04JwtAuthenticationEntryPoint())  // 配置自定义JWT认证失败处理器
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(URL_WHITELIST).permitAll()     // 配置白名单
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
