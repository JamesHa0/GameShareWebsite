package com.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.game.util.SnowflakeIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;

@TableName("order")
@Data
@AllArgsConstructor
public class Order {
    @TableField(exist = false)  //订单所属用户；非表字段
    private User user;

    public Order() {    //手搓无参构造器；雪花算法自动生成订单号
        SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator();
        this.onumber = String.valueOf(snowflakeIdGenerator.nextId());
    }

    @TableId(type = IdType.ASSIGN_ID)
    private String onumber;

    @TableField(exist = true)
    private String uid;

    @TableField(exist = true)
    private String gid;

    private String otime;
}
