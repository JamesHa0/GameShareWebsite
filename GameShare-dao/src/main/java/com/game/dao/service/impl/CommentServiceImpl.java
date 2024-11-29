package com.game.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.game.common.core.domain.entity.Comment;
import com.game.common.utils.DateUtil;
import com.game.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class CommentServiceImpl {
    @Autowired
    private com.game.dao.mapper.CommentMapper commentMapper;

    public Result getCommentByPage(String gid, Integer pageNum, Integer pageSize){
//        Page<Comment> page = Page.of(pageNum, pageSize);
//        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("gid", gid);
        return Result.ok().data("comments", commentMapper.getCommentByPageWithCTE(gid, pageNum, pageSize));
    }

    public Result doCommentLike(String uid, String gid, String cid){
        String action = "";
        UpdateWrapper<Comment> updateWrapper = new UpdateWrapper<>();
        if(commentMapper.queryIsLikedComment(uid, cid) == 0){    // 记录中没有数据，故进行点赞操作
            action = "doLike";
            updateWrapper.eq("cid", cid).setSql("clike = clike + 1");
            commentMapper.update(null, updateWrapper);
            return commentMapper.doCommentLike(uid, gid, cid) > 0 ? Result.ok().data("action", action) : Result.error();
        } else {
            action = "disLike";
            updateWrapper.eq("cid", cid).setSql("clike = clike - 1");
            commentMapper.update(null, updateWrapper);
            return commentMapper.disCommentLike(uid, cid) > 0 ? Result.ok().data("action", action) : Result.error();
        }
    }

    public Result doComment(String uid, String gid, String commentText) {
        Comment comment = new Comment();
        String date = DateUtil.getSQLTimeNow();
        comment.setUid(uid);
        comment.setGid(gid);
        comment.setComment(commentText);
        comment.setCtime(date);
        return commentMapper.doComment(comment) > 0 ? Result.ok() : Result.error();
    }
}
