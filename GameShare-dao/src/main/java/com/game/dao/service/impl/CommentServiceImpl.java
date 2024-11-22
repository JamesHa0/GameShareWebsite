package com.game.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.game.common.core.domain.entity.Comment;
import com.game.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl {
    @Autowired
    private com.game.dao.mapper.CommentMapper commentMapper;

    public Result getCommentByPage(String gid, Integer pageNum, Integer pageSize){
        Page<Comment> page = Page.of(pageNum, pageSize);
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gid", gid);
        return Result.ok().data("comments", commentMapper.selectPage(page, queryWrapper).getRecords());
    }

    public Result doCommentLike(String uid, String cid){
        if(commentMapper.queryIsLikedComment(uid, cid) > 0){    // 已点过赞，执行取消点赞操作
            return commentMapper.disCommentLike(uid, cid) > 0 ? Result.ok() : Result.error();
        }
        return commentMapper.doCommentLike(uid, cid) > 0 ? Result.ok() : Result.error();
    }
}
