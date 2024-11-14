package com.game.framework.security;

import com.game.common.utils.StrUtil;
import com.game.dao.mapper.UserMapper;
import com.game.common.utils.JwtUtil;
import com.game.common.utils.Result;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class My01JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsService;

    @Autowired
    private UserMapper userMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("【01jwt过滤器】进入");
        String authorizationHeader = request.getHeader("Authorization");
        System.out.println("【01jwt过滤器】请求头附带的jwt是：" + authorizationHeader);

        String jwt = getString(authorizationHeader);
        if (jwt != null && SecurityContextHolder.getContext().getAuthentication() == null) {    // get 权限 == null
            Result result = JwtUtil.validateJWT(jwt);
            if (result.isSuccess()) {
                String uid = (String)result.getData().get("uid");
                String utel = userMapper.getUtelByUid(uid);
                System.out.println("【01jwt过滤器】jwt验证通过，用户id：" + uid + "，用户手机号：" + utel );
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        utel,   // 用户名
                        null,   // 密码
                        myUserDetailsService.loadUserByUsername(utel).getAuthorities()  // 权限列表
                );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);       // set 权限 = 值
            } else {
                System.out.println("【01jwt过滤器】jwt校验失败：" + result.getMessage());
            }
        } else {
            if(jwt == null)
                System.out.println("【01jwt过滤器】jwt为空，等待登录认证过滤器继续校验…… ");
            if(SecurityContextHolder.getContext().getAuthentication() != null){
                System.out.println("【01jwt过滤器】SecurityContextHolder.getContext().getAuthentication() 竟然不为空！见鬼了");
            }
        }


        chain.doFilter(request, response);
    }

    private static String getString(String authorizationHeader) {
        String jwt = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
        }
        return jwt;
    }
}
