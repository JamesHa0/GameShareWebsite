package com.game.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.game.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("""
            SELECT d.id,d.`name`,d.`url`,d.parent_id,d.`type`,d.permit,d.remark FROM `user` a
            LEFT JOIN `user_role` b ON a.uid=b.user_id
            LEFT JOIN `role_permission` c ON b.role_id=c.role_id
            LEFT JOIN `sys_permission` d ON c.permission_id=d.id
            WHERE a.uid=#{uid}""")
    List<Permission> selectPermissionByUserId(String uid);


    @Select("""
            SELECT d.id,d.`name`,d.`url`,d.parent_id,d.`type`,d.permit,d.remark FROM `user` a
            LEFT JOIN `user_role` b ON a.utel=b.user_id
            LEFT JOIN `role_permission` c ON b.role_id=c.role_id
            LEFT JOIN `sys_permission` d ON c.permission_id=d.id
            WHERE a.utel=#{utel}""")
    List<Permission> selectPermissionByUtel(String utel);
}
