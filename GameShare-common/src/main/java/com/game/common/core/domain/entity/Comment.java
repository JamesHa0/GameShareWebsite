package com.game.common.core.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("game_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @TableId(type=IdType.AUTO)//自增
    private String cid;

    private String uid;

    private String gid;

    private String ctime;

    private String comment;

    private String clike;

    private String parentCid;

    private  String parentUid;

    private String delFlag;

    @TableField(value = "cpath", exist = false)
    private String cpath;

    @TableField(value = "parent_uname", exist = false)
    private String parentUname;

    @TableField(value = "uname", exist = false)
    private String uname;
}
