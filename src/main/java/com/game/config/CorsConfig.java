package com.game.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //允许全部跨路由路径的跨域访问
                .allowedOrigins("http://localhost:5173")
//                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowCredentials(true)     //是允许发送cookie
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
