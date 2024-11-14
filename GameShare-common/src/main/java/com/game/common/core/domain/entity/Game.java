package com.game.common.core.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("game")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @TableId(value="gid",type = IdType.AUTO)
    private String gid;

    @TableField(exist = true)
    private String gname;

    private Float gprice;

    private String gdeveloper;

    private String gpublisher;

    private String greleaseDate;    //mybatisPlus会自动驼峰转下划线

    private String gdescription;

    private String gzhname;

    private String gtag;
}
