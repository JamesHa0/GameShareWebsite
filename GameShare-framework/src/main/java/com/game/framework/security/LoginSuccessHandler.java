package com.game.framework.security;

import com.game.dao.mapper.UserMapper;
import com.game.common.core.domain.entity.User;
import com.game.common.utils.JSONUtil;
import com.game.common.utils.JwtUtil;
import com.game.common.utils.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired private UserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("【Login success】");

        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();

        // 生成JWT，并放置到请求头中
        User user = userMapper.selectUserByUtel(authentication.getName());
        HashMap<String, String> claims = new HashMap<>();   // 制造claims
        claims.put("uname", user.getUname());
        claims.put("authorities", authentication.getAuthorities().toString());
        String jwt = JwtUtil.generateToken(user.getUid(), claims);
//        System.out.println("sub 是：" + JwtUtil.parseToken(jwt).getSubject());
        response.setHeader("authorization", jwt);

        System.out.println(">>> 【Login success】jwt生成成功，token：" + jwt);
        Result result = Result.ok().message("登录成功").data("Token", jwt);

        outputStream.write(JSONUtil.toJson(result).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
