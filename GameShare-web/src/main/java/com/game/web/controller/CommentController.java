package com.game.web.controller;

import com.game.common.core.domain.entity.Comment;
import com.game.common.utils.Result;
import com.game.dao.mapper.CommentMapper;
import com.game.dao.service.impl.CommentServiceImpl;
//import io.swagger.v3.oas.annotations.Operation;
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

//    @Operation(summary = "查询某游戏的【全部】评论")
//    @GetMapping("/{gid}")
//    public List<Comment> listCommentsByGid(@PathVariable String gid) {
//        return commentMapper.queryCommentsByGid(gid);
//    }

//    @Operation(summary = "查询某游戏评论数")
    @GetMapping("/CommentNum/{gid}")
    public int queryCommentNumByUid(@PathVariable String gid) {
        return commentMapper.queryCommentNumByGid(gid);
    }

//    @Operation(summary = "查询某游戏评论【分页】")
    @GetMapping("/listByPage/{gid}/{pageNum}/{pageSize}")
    public Result listCommentsByUid(@PathVariable String gid, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return commentServiceImpl.getCommentByPage(gid, pageNum, pageSize);
    }

//    @Operation(summary = "给评论点赞/取消点赞")
    @PostMapping("/doLike/{uid}/{cid}")
    public Result doCommentLike(@PathVariable String uid, @PathVariable String cid) {
        return commentServiceImpl.doCommentLike(uid, cid);
    }
}
