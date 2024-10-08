//package com.game2.controller;
//
//import com.game2.entity.User;
//import com.game2.mapper.test_UserMapper;
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
////RESTful四种方法演示
//@RestController
//public class test_UserController {
//
//    @Autowired
//    private test_UserMapper testUserMapper;
//
//    @Operation(summary = "全查用户表")
//    @GetMapping("/user")
//    public List getAllUser()        //对象自动转为json，无需担心
//    {
//        List<User> userList = testUserMapper.findAll();
//        System.out.println(userList);
//        return userList;
//    }
//
//    @GetMapping("/user/{id}")    //RESTful的路径方式传参
//    public String getUserById(@PathVariable int id)
//    {
//        return "getUserById";
//    }
//
//    @Operation(summary = "添加用户")
//    @PostMapping("/user")
//    public String addUser(User user)
//    {
//        testUserMapper.insertUser(user);
//        return "已填加";
//    }
//
//    @Operation(summary = "修改用户")
//    @PutMapping("/user")
//    public String updateUser(User user)
//    {
//        return "已修改";
//    }
//
//    @Operation(summary = "删除用户")
//    @DeleteMapping("/user/{id}")
//    public String deleteUser(@PathVariable int id)
//    {
//        return "已删除";
//    }
//}
