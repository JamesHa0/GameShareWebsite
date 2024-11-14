//package com.game.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class LoginViewController {
//    // 采用ThymeLeaf编写一个登录表单
//    @GetMapping("/login")
//    public String toLogin() {
////        System.out.println("【进入login页】这里调用了LoginViewController中的toLogin方法。");
//        return "login"; // 返回字符串 "login"，通常会被 Thymeleaf 模板引擎用来解析并呈现 login.html 模板。
//    }
//
//    @GetMapping("/loginSuccess")
//    public String toLoginSuccess() {
//        System.out.println("【】这里调用了LoginViewController中的toLoginSuccess方法。");
//        return "loginSuccess";
//    }
//
//    @GetMapping("/loginFail")
//    public String toLoginFail() {
//        System.out.println("【】这里调用了LoginViewController中的toLoginFail方法。");
//        return "loginFail";
//    }
//}
