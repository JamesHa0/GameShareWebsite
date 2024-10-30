package com.game.web.controller;
import com.game.common.core.domain.entity.User;
import com.game.dao.mapper.UserMapper;

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

    @GetMapping("/{uid}")
//    @PreAuthorize("hasRole('ROLE_USER')")
    @PreAuthorize("hasAuthority('user:manager')")
    @Operation(summary = "查询某用户的【单个】信息")
    public User listOneUser(@PathVariable String uid) {
        return userMapper.selectById(uid);
    }

    /**
     * 获取单个用户 及其 所有订单
     */
    /*@GetMapping("/userAndOrders/{uid}")
    @Operation(summary = "查询某用户的【单个】信息，并查询其【全部】订单")
    public User listOneUserAndOrder(@PathVariable String uid) {
        return userMapper.selectOneUserAndOrders(uid);
    }*/

    /**
     * 获取所有用户和订单
     */
    /*@GetMapping("/allUsersAndOrders")
    @Operation(summary = "查询【全部】用户，并查询其【全部】订单")
    public List<User> listAllUsersAndOrders() {
        return userMapper.selectAllUsersAndOrders();
    }*/
    /**
     * 获取所有用户，分页查询
     */
//    @GetMapping("allUsersByPage")
//    public IPage<User> listAllUsersByPage() {
//        Page<User> page = new Page<>(3, 2);     //从第3页开始查询，每页显示2条记录。
//        return userMapper.selectPage(page, null);
//    }

//    @PostMapping("/one")
//    @Operation(summary = "增加单个用户")
//    public Result addUser(@PathVariable User user) {        //这里试用了Result自定义返回类
//        int i =userMapper.insert(user);
//        if(i>=0){
//            return Result.ok().data("操作","新增用户");
//        }else {
//            return Result.error().data("操作", "新增用户");
//        }
//    }


}
