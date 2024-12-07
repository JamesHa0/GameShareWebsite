package com.game.framework.security;

import com.game.common.utils.JSONUtil;
import com.game.common.utils.Result;
import com.game.common.utils.ResultCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.err.println("【Jwt EntryPoint】 jwt认证失败：jwt无效或为空。");


        response.setStatus(ResultCode.JWT_INVALID); // 设置状态码为 401
        response.setContentType("application/json;charset=UTF-8");

        Result result = Result.error().code(ResultCode.JWT_INVALID).message("Jwt验证失败：jwt为空、无效或被篡改。请登录后重试……");

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(JSONUtil.toJson(result).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();

    }
}
