package com.game.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.game.common.core.domain.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where uid=#{uid}")
    User selectUserByUid(String uid);

    @Select("select * from user where utel=#{utel}")
    User selectUserByUtel(String utel);


    @Select("select * from user")
    @Results(
            {
                    @Result(property = "uid",column = "uid"),
                    @Result(property = "uname",column = "uname"),
                    @Result(property = "upassword",column = "upassword"),
                    @Result(property = "uemail",column = "uemail"),
                    @Result(property = "ugender",column = "ugender"),
                    @Result(property = "uaddress",column = "uaddress"),
                    @Result(property = "utel",column = "utel"),
                    @Result(property = "urole",column = "urole"),
                    @Result(property = "upoint",column = "upoint"),
                    @Result(property = "orders",javaType = List.class,column = "uid",       //声明为List类，参考列为uid
                            many = @Many(select = "com.game.mapper.OrderMapper.selectByUid"))      //声明其调用的哪个Mapper的哪个方法
            })
    List<User> selectAllUsersAndOrders();



    @Select("select * from user where uid=#{uid}")
    @Results({
                    @Result(property = "uid",column = "uid"),
                    @Result(property = "uname",column = "uname"),
                    @Result(property = "upassword",column = "upassword"),
                    @Result(property = "uemail",column = "uemail"),
                    @Result(property = "ugender",column = "ugender"),
                    @Result(property = "uaddress",column = "uaddress"),
                    @Result(property = "utel",column = "utel"),
                    @Result(property = "urole",column = "urole"),
                    @Result(property = "upoint",column = "upoint"),
                    @Result(property = "orders",javaType = List.class,column = "uid",       //声明为List类，参考列为uid
                            one = @One(select = "com.game.mapper.OrderMapper.selectByUid"))      //声明其调用的哪个Mapper的哪个方法
            })
    User selectOneUserAndOrders(String uid);


    @Select("select utel from user where uid=#{uid}")
    String getUtelByUid(String uid);


    /**
     * 根据用户id和游戏id，点赞 / 取消点赞
     */
    @Update("""
        update user
        set uliked_games = JSON_SET(
            uliked_games,
            '$.gid_'+#{gid}, #{action}
        )
        WHERE uid = #{uid};
        """)
    int updateGameLike(String uid, String gid, String action);

    /**
     * 对于user表，对指定【表字段】、指定【json_column字段】，查询对应值为ture的总数。（注意用的是${}）
     */
    @Select("""
        SELECT COUNT(*)
        FROM user
        WHERE JSON_EXTRACT(${column}, ${json_column}) = true;
        """)
    int queryGameLikeNum(String column, String json_column);
}
