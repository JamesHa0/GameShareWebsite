package com.game.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.game.common.core.domain.entity.Comment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {

    @Select("select count(*)  from `comment` where gid=#{gid}")
    int queryCommentNumByGid(String gid);

    @Select("select * from `comment` where gid = #{gid}")
    List<Comment> queryCommentsByGid(String gid);
}
