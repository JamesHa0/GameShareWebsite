package com.game.web.controller;

import com.game.common.core.domain.entity.Comment;
import com.game.common.utils.Result;
import com.game.dao.mapper.CommentMapper;
import com.game.dao.service.impl.CommentServiceImpl;
//import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comment")
@RestController
public class CommentController {

    @Autowired 
    private CommentMapper commentMapper;
    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @Operation(summary = "查询某游戏评论数")
    @GetMapping("/CommentNum/{gid}")
    public int queryCommentNumByUid(@PathVariable String gid) {
        return commentMapper.queryCommentNumByGid(gid);
    }

    @Operation(summary = "查询某游戏评论（分页）")
    @GetMapping("/listByPage/{gid}/{pageNum}/{pageSize}")
    public Result listCommentsByUid(@PathVariable String gid, @PathVariable String pageNum, @PathVariable String pageSize) {
        return commentServiceImpl.getCommentByPage(gid, Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    }

    @Operation(summary = "给评论点赞/取消点赞")
    @PostMapping("/doLike")
    public Result doCommentLike(@RequestParam String uid, @RequestParam String gid, @RequestParam String cid) {
        return commentServiceImpl.doCommentLike(uid, gid, cid);
    }

    @Operation(summary = "评论")
    @PostMapping("/doComment")
    public Result doComment(@RequestParam String uid, @RequestParam String gid, @RequestParam String commentText){
        return commentServiceImpl.doComment(uid, gid, commentText);
    }

    @Operation(summary = "回复评论")
    @PostMapping("/doReply")
    public Result doReply(@RequestBody Comment comment){
        return commentServiceImpl.doReply(comment);
    }

}
