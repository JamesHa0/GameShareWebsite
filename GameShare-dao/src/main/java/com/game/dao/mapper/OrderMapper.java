package com.game.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.game.common.core.domain.entity.Game;
import com.game.common.core.domain.entity.Order;
import com.game.common.core.domain.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

//    @Select("select * from `order` where uid = #{uid}")
//    List<Order> selectByUid(String uid);

    @Insert("""
        insert into `order` values
        (#{onumber}, #{uid}, #{gid}, #{otime})
    """)
    int insertOrder(Order order);

    @Select("select * from `order` where uid=#{uid} and gid=#{gid}")
    Order selectByUidAndGid(String uid,String gid);    //被UserMapper调用

    // 查询订单及其所系游戏信息
    @Select("select * from `order` where uid = #{uid}")
    @Results({
            @Result(property = "onumber", column = "onumber"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "gid", column = "gid"),
            @Result(property = "otime", column = "otime"),
            @Result(property = "game", javaType = Game.class, column = "gid",
                one = @One(select = "com.game.dao.mapper.GameMapper.selectById")
            )
    })
    List<Order> selectOrderAndItsGame(String uid);

    // 查询所有订单 及其 所属的用户
//    @Select("select * from `order`")
//    @Results({
//            @Result(property = "onumber",column = "onumber"),
//            @Result(property = "uid",column = "uid"),
//            @Result(property = "gid",column = "gid"),
//            @Result(property = "otime",column = "otime"),
//            @Result(property = "user",javaType = User.class,column = "uid",       //声明为User类
//                    one = @One(select = "com.game.web.mapper.UserMapper.selectById")     //one，只查询一个
//            )
//    })
//    List<Order> listAllOrdersAndItsUser();



}
