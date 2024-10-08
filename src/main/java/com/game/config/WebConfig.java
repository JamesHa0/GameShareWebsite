package com.game.config;

//import com.game.interceptor.JwtInterceptor;
//import com.game.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override   //激活拦截器，配置拦截器路径：user
    public void addInterceptors(InterceptorRegistry registry)
    {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**");    //（测试）login拦截器
//        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/**");   //JWT拦截器
    }
}
