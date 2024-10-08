//package com.game.security;
//
//import com.game.util.JSONUtil;
//import com.game.util.Result;
//import jakarta.servlet.ServletOutputStream;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//@Component
//public class My03JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
//        System.out.println("【03JWT认证失败处理器】进入");
//
//        httpServletResponse.setContentType("application/json;charset=UTF-8");
//        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
//
//        Result result = Result.error().message("请先登录");
//
//        System.out.println("【03】请先登录");
//
//        outputStream.write(JSONUtil.toJson(result).getBytes(StandardCharsets.UTF_8));
//        outputStream.flush();
//        outputStream.close();
//    }
//}
