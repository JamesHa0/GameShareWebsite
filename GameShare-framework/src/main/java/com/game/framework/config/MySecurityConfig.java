package com.game.framework.config;

import com.game.framework.security.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 通过构造函数注入依赖
    public MySecurityConfig(UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder) {
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        return new JwtAuthenticationFilter();
    }
    @Bean
    public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint();
    }
    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }
    @Bean
    public LoginFailureHandler loginFailureHandler() {
        return new LoginFailureHandler();
    }


    private static final String[] URL_WHITELIST = {
            "/error",
            "/register",
            "/login",         //登录
            "/logout",        //登出
            "/captcha",        //验证码
            "/favicon.ico",
            "/v3/api-docs/**","/swagger**/**",
    };

    @Autowired
    private CustomCorsConfigurationSource customCorsConfigurationSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(customCorsConfigurationSource))      // 解决security 跨域问题
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)     // 配置自定义JWT认证过滤器
                .formLogin(form -> form
                        .usernameParameter("utel").passwordParameter("upsw")
                        .loginPage("/login")
                        .successHandler(loginSuccessHandler())      // 配置自定义登录成功处理器
                        .failureHandler(loginFailureHandler())      // 配置自定义登录失败处理器
                )
                .exceptionHandling(
                        exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint())  // 配置自定义JWT认证失败处理器
                )
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(URL_WHITELIST).permitAll()
                            .anyRequest().authenticated();
                    }
                )
        ;

        return http.build();
    }
}
