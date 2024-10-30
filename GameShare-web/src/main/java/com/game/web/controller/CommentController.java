package com.game.web.controller;

import com.game.common.core.domain.entity.Comment;
import com.game.dao.mapper.CommentMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/comment")
@RestController
public class CommentController {

    @Autowired private CommentMapper commentMapper;

    @Operation(summary = "查询某游戏的【全部】评论")
    @GetMapping("/{gid}")
    public List<Comment> listCommentsByGid(@PathVariable String gid) {
        return commentMapper.queryCommentsByGid(gid);
    }

    @Operation(summary = "查询某游戏评论数")
    @GetMapping("/CommentNum/{gid}")
    public int queryCommentNumByUid(@PathVariable String gid) {
        return commentMapper.queryCommentNumByGid(gid);
    }
}
