package com.game.common.core.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("sys_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable{
    private Integer id;
    private String name;
    private String remark;
}
