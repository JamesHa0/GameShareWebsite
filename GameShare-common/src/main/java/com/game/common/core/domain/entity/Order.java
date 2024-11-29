package com.game.common.core.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.game.common.utils.DateUtil;
import com.game.common.utils.SnowflakeIdGenerator;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;

@TableName("order")
@Data
@AllArgsConstructor
public class Order {
    public static void main(String[] args){
        SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator();
        for(int i=0;i<50;i++){
            System.out.println(snowflakeIdGenerator.nextId());
        }
    }


    public Order() {    //手搓无参构造器；雪花算法自动生成订单号
        SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator();
        this.onumber = String.valueOf(snowflakeIdGenerator.nextId());
    }

    public Order(String uid, String gid) {
        SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator();
        this.onumber = String.valueOf(snowflakeIdGenerator.nextId());
        this.uid = uid;
        this.gid = gid;
        this.otime = DateUtil.getSQLTimeNow();
    }

    @TableId(type = IdType.ASSIGN_ID)
    private String onumber;

    @TableField
    private String uid;

    @TableField
    private String gid;

    @TableField
    private String otime;



    @TableField(exist = false)  //订单所属用户；非表字段（测试用）
    private User user;
}
