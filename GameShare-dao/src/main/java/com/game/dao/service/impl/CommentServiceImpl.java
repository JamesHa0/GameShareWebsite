package com.game.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.game.common.core.domain.entity.Comment;
import com.game.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl {
    @Autowired
    private com.game.dao.mapper.CommentMapper commentMapper;

    public Result getCommentByPage(String gid, Integer pageNum, Integer pageSize){
        Page<Comment> page = Page.of(pageNum, pageSize);
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gid", gid);
        return Result.ok().data("comments", commentMapper.selectPage(page, queryWrapper).getRecords());
    }
}
