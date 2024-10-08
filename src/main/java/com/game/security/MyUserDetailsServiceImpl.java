package com.game.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.game.entity.Permission;
import com.game.entity.Role;
import com.game.entity.User;
import com.game.mapper.PermissionMapper;
import com.game.mapper.RoleMapper;
import com.game.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录服务实现类型
 */
@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired private UserMapper userMapper;
    @Autowired private RoleMapper roleMapper;
    @Autowired private PermissionMapper permissionMapper;

    /**
     * 方法实现内容：根据用户名（在这里指手机号）查询用户对象，和用户权限列表
     * @param utel
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String utel) throws UsernameNotFoundException {
        System.out.println("【找用户】调用loadUserByUsername方法，现在正在找该用户及其权限集合：");

        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
        lqw.eq(User::getUtel , utel);       //where utel=参数
        User user = userMapper.selectOne(lqw);
        if(user == null){
            System.err.println("【找用户】用户不存在");
            throw new UsernameNotFoundException("【找用户】用户不存在");
        }

//开始查询已登录用户的权限集合：
        //1，查询角色：
        List<Role> roles = roleMapper.selectRolesByUserId(user.getUid());
        //2，查询权限：
        List<Permission> permissionList = permissionMapper.selectPermissionByUserId(user.getUid());
        //3，定义一个字符串泛型的list集合对象
        List<String> authorityList = new ArrayList<>();
        for(Role role : roles){
            authorityList.add("ROLE_" + role.getName());    //角色名称纳入到权限管理，必须加入前缀 ‘ROLE_’
        }
        for (Permission m : permissionList){
            authorityList.add(m.getPermit());   //权限字符串描述，不需要加入前缀‘ROLE_’
        }
        System.out.println("【找到了用户】登录者的权限列表为："+authorityList);
        org.springframework.security.core.userdetails.User userDetails =
                new org.springframework.security.core.userdetails.User(
                        user.getUtel(),     //用户名
                        user.getUpsw(),     //密码
                        AuthorityUtils.createAuthorityList(authorityList)   //权限列表
                );

        return userDetails;
    }

}
