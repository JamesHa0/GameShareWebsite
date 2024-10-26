package com.game.security;

import com.game.entity.User;
import com.game.mapper.UserMapper;
import com.game.util.JSONUtil;
import com.game.util.JwtUtil;
import com.game.util.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


public class My04LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired private UserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("【04登录成功处理器】进入");

        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();

        // 生成JWT，并放置到请求头中
        User user = userMapper.selectUserByUtel(authentication.getName());
        HashMap<String, String> claims = new HashMap<>();   // 制造claims
        claims.put("uname", user.getUname());
        claims.put("authorities", authentication.getAuthorities().toString());
        String jwt = JwtUtil.generateToken(user.getUid(), claims);
        System.out.println("sub 是：" + JwtUtil.parseToken(jwt).getSubject());
        response.setHeader("authorization", jwt);

        System.out.println("!**************【jwt过滤器】jwt生成成功，token：" + jwt);
        Result result = Result.ok().message("登录成功").data("Token", jwt);

        outputStream.write(JSONUtil.toJson(result).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
