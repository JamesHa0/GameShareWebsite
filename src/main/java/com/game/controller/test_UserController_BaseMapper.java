//package com.game2.controller;
//
//import com.game2.entity.User;
//import com.game2.mapper.test_UserMapper_BaseMapper;
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
////利用Mybatis Plus的BaseMapper接口实现增删改查
//@RestController
//public class test_UserController_BaseMapper {
//
//    @Autowired
//    private test_UserMapper_BaseMapper userMapper;
//
//    @Operation(summary = "全查用户表")
//    @GetMapping("/user_Plus")
//    public List getAllUser()        //对象自动转为json，无需担心
//    {
//        //List<User> userList = userMapper.selectList(null);
//        List<User> userList = userMapper.selectAllUser();
//        System.out.println(userList);
//        return userList;
//
//    }
//}
