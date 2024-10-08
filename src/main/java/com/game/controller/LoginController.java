//package com.game.controller;
//
//import com.game.entity.User;
//import com.game.util.JwtUtil;
//import com.game.util.Result;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Controller
//public class LoginController {
//
//    @PostMapping("/login")
//    public Result login(@RequestBody User user, HttpServletResponse response){
////        User user = new User();
////        user.setUtel("12344444444");
//
//        String token = JwtUtil.generateToken(user);
//        Cookie cookie = new Cookie("token", token);
//        cookie.setHttpOnly(true);  // 增加安全性，防止JS访问cookie
//        cookie.setSecure(true);    // 确保只在HTTPS连接中发送cookie
//        cookie.setMaxAge(86400);   // 设置cookie过期时间
//        cookie.setPath("/");       // 全站有效
//        response.addCookie(cookie);  // 添加到响应中
//        System.out.println("【user控制器】token:"+token);
//        return Result.ok().data("token",token);
//    }
//
//}
