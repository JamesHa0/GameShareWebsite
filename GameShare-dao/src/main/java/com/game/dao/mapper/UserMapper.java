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
                            one = @One(select = "com.game.dao.mapper.OrderMapper.selectByUid"))      //声明其调用的哪个Mapper的哪个方法
            })
    User selectOneUserAndOrders(String uid);


    @Select("select utel from user where uid=#{uid}")
    String getUtelByUid(String uid);


    @Update("""
        update user
        set upoint = upoint - #{price}
        where uid = #{uid};
    """)
    void deductPoint(String uid, Float price);

    @Update("""
        update user
        set upoint = upoint + #{point}
        where uid = #{uid};
    """)
    void risePoint(String uid, Float point);

    @Update("insert into sign_in values(#{uid}, #{date})")
    void insertSignIn(String uid, String date);

    @Select("select count(*) from sign_in where uid = #{uid} and created_on = #{date}")
    int queryIsSignedIn(String uid, String date);
}
