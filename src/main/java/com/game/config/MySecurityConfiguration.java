//package com.game.config;
//
//import com.game.security.MyLoginAuthenticationProvider;
//import com.game.security.MyPasswordEncoder;
//import com.game.security.MyUserDetailsServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity  //官方推荐
//public class MySecurityConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
//
//    private MyUserDetailsServiceImpl userDetailsService;
//
//    /**
//     * 配置密码解析器，创建一个passwordEncoder类型的bean对象
//     *
//     * @return
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        //return new BCryptPasswordEncoder(4);//强度，与加密速度成反比。4-31
//        return new MyPasswordEncoder();
//    }
//
//
//
//    /**
//     * 配置security过滤器链
//     * @param security
//     * @return
//     * @throws Exception
//     */
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity security ) throws Exception {
//
//        /// 1，认证配置
//        // 创建匿名内部类对象，实现认证相关配置
//        AuthenticationProvider authProvider = new MyLoginAuthenticationProvider(userDetailsService, new MyPasswordEncoder());
//        security.authenticationProvider(authProvider);  // 使用自定义的认证提供者。
//        Customizer<FormLoginConfigurer<HttpSecurity>> customizer = new Customizer<FormLoginConfigurer<HttpSecurity>>(){
//            @Override
//            public void customize(FormLoginConfigurer<HttpSecurity> configurer) {
//                configurer.loginPage("/login"); // 自定义登录页面，默认为/login，必须是get，需返回一个ModelAndView
//                //configurer.loginProcessingUrl("http://localhost:8080/login");    // 自定义登录处理URL，默认为/login，必须是post，需返回一个ModelAndView
//                configurer.usernameParameter("utel").passwordParameter("upsw");     // 自定义用户名、密码参数名，默认为username、password
//                configurer.defaultSuccessUrl("/login?success=行了", true);   // 自定义认证成功后，重定向到/ ，true表示总是重定向到/loginSuccess，false表示重定向到上一次访问地址
//                configurer.failureUrl("/login?error=不行");      // 自定义认证失败后，重定向到/login?error，true表示总是重定向到/login?error，false表示重定向到上一次访问地址
//            }
//        };
//        security.formLogin(customizer);// 设置认证配置
//
//
//        /// 2，授权配置
//        security
//                .csrf(AbstractHttpConfigurer::disable) // 禁用CSRF保护
//                .authorizeHttpRequests(authorize -> authorize   // 在security框架中，登录页面地址和登录请求地址，默认都是不校验权限、不校验认证的：（建议把登录页面请求地址、登录请求地址都设置在授权配置中。）
//                        .requestMatchers("/swagger-ui/**").permitAll() // 允许访问Swagger相关的路径
//                        .requestMatchers("/login","/loginHandle","/loginFail").anonymous()  // /login允许未登录时访问，防止拦截登录页面再跳到登录页面造成死循环重定向次数超过限制
//                        //.requestMatchers(HttpMethod.POST,"/example/**").anonymous()  // 仅允许Post、未登录状态访问example文件
//                        .requestMatchers("/admin/**").hasRole("ADMIN")   // 仅管理员角色才能访问
//                        .anyRequest().authenticated() // 所有其他请求都需要认证
//                )
//        ;
//        return security.build();
//    }
//
//
//}
