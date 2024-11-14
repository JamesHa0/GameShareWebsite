package com.game.common.core.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.core.util.Json;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@TableName("user")     //把类名和表名映射
@Data   //get&set;toString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(value = "uid", type = IdType.AUTO)     // 主键，声明为自增
    private String uid;

    private String uname;

    @TableField(value="utel",exist = true)  //声明为必填字段
    private String utel;

    private String uemail;

    private String urole;

    private String ugender;

    private String uaddress;

    @TableField(value="upsw",exist = true)
    private String upsw;

    private Float upoint;

    private Json uliked_games;

    private Json uliked_comments;


    @TableField(exist = false)      //不是实际字段；用于描述订单
    private List<Order> orders;

}
