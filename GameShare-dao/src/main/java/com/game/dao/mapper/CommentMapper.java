package com.game.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.game.common.core.domain.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {

    @Select("select count(*)  from game_comment where gid=${gid}")
    int queryCommentNumByGid(String gid);


//    @Select("select * from game_comment where gid = ${gid}")
//    List<Comment> queryCommentsByGid(String gid);

    @Select("select cid from game_comment_like where uid = ${uid} and gid = ${gid}")
    List<String> queryLikedCommentIds(String uid, String gid);

    @Select("select count(*) from game_comment_like where uid =${uid} and cid = ${cid}")
    int queryIsLikedComment(@PathVariable String uid, @PathVariable String cid);

    @Insert("insert into game_comment_like values(${uid}, ${gid}, ${cid})")
    int doCommentLike(@PathVariable String uid,  @PathVariable String gid, @PathVariable String cid);

    @Delete("delete from game_comment_like where uid=${uid} and cid=${cid}")
    int disCommentLike(String uid, String cid);
}
