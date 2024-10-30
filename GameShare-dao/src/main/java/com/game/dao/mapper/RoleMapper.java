package com.game.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.game.common.core.domain.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    @Select("""
            SELECT c.id, c.name, c.remark FROM user a
            LEFT JOIN user_role b ON a.uid = b.user_id
            LEFT JOIN sys_role c ON b.role_id = c.id
            WHERE a.uid = #{uid}""")
    List<Role> selectRolesByUserId(String id);

    @Select("""
            SELECT c.id, c.name, c.remark FROM user a
            LEFT JOIN user_role b ON a.uid = b.user_id
            LEFT JOIN sys_role c ON b.role_id = c.id
            WHERE a.utel = #{utel}""")
    List<Role> selectRolesByUtel(String utel);
}
