//package com.game.security;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//@Component
//public class My00LoginAuthenticationProvider implements AuthenticationProvider {
//
//    private final MyUserDetailsServiceImpl userDetailsService;
//    private final MyPasswordEncoder passwordEncoder;
//
//    public My00LoginAuthenticationProvider(MyUserDetailsServiceImpl userDetailsService, MyPasswordEncoder passwordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        System.out.println("【00认证提供者】进入");
//
//        // 自动获取的表单数据：
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//        if (userDetails != null && passwordEncoder.matches(password, userDetails.getPassword())) {
//            System.out.println("【00】密码匹配了");
//            return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
//        } else {
//            System.err.println("【00】密码不匹配。");
//            throw new BadCredentialsException("【00】密码不匹配。 user = " + username);
//        }
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//}
