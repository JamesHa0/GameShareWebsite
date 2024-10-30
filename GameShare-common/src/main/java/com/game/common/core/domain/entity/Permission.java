package com.game.common.core.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("sys_permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {
    private Integer id;
    private String name;
    private String url;
    private Integer parentId;
    private String type;    //权限类型， M - 菜单， A - 子菜单， U - 普通请求
    private String permit;
    private String remark;
}
