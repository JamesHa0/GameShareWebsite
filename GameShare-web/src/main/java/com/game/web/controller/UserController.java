package com.game.web.controller;
import com.game.common.core.domain.entity.User;
import com.game.common.utils.Result;
import com.game.dao.mapper.UserMapper;

import com.game.dao.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin    //声明为跨域，这里作演示。
@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true,securedEnabled = true)
/**
 * prePostEnabled = true 的作用的是启用Spring Security的@PreAuthorize 以及@PostAuthorize 注解。
 * securedEnabled = true 的作用是启用Spring Security的@Secured 注解。
 * jsr250Enabled = true 的作用是启用@RoleAllowed 注解
 */
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{uid}")
//    @PreAuthorize("hasRole('ROLE_USER')")
    @PreAuthorize("hasAuthority('user:manager')")
    @Operation(summary = "查询某个用户的信息")
    public Result listOneUser(@PathVariable String uid) {
        User user = userMapper.selectById(uid);
        return Result.ok().data("user", user);
    }

    @PostMapping("/signIn")
    @Operation(summary = "用户每日签到")
    public Result signIn(@RequestParam String uid) {
        return userService.signIn(uid);
    }

}
