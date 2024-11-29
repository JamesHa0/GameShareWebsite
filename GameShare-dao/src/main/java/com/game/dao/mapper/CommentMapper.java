package com.game.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.game.common.core.domain.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {

    @Select("select count(*)  from game_comment where gid=#{gid}")
    int queryCommentNumByGid(String gid);

    @Select("""
        WITH RECURSIVE CommentCTE AS (
          SELECT
                c.cid,
                c.uid,
                c.gid,
                c.ctime,
                c.`comment`,
                c.clike,
                c.parent_cid,
                c.parent_uid,
                c.del_flag,
                cast(CONCAT(LPAD(99999-clike, 5, '0'), '[', 9999999999-UNIX_TIMESTAMP(STR_TO_DATE(c.ctime, '%Y-%m-%d %H:%i:%s')), ']') AS CHAR(255)) AS cpath,  # cpath指涉评论排序路径；一级评论的cpath由【某极大值-赞数 + 某极大值-时间戳】 组成；二级及更高级评论由【其父评论cpath + 某极大值-时间戳】 组成。
                _u.uname AS parent_uname,
                u.uname AS uname
          FROM
            game_comment c
            left JOIN user _u ON c.parent_uid = _u.uid
            JOIN user u ON c.uid = u.uid
          WHERE
            c.parent_uid IS NULL -- 从顶级评论开始
          UNION ALL
          SELECT
                c2.cid,
                c2.uid,
                c2.gid,
                c2.ctime,
                c2.`comment`,
                c2.clike,
                c2.parent_cid,
                c2.parent_uid,
                c2.del_flag,
                CONCAT(cc.cpath,'#',CONCAT('[', 9999999999-UNIX_TIMESTAMP(STR_TO_DATE(c2.ctime, '%Y-%m-%d %H:%i:%s')), ']')) AS cpath,
                _u2.uname AS parent_uname,
                u2.uname AS uname
          FROM
            game_comment c2
            JOIN user _u2 ON c2.parent_uid = _u2.uid
            JOIN user u2 ON c2.uid = u2.uid
            JOIN CommentCTE cc ON c2.parent_cid = cc.cid
        )
        SELECT * FROM CommentCTE order BY CommentCTE.cpath;
    """)
    List<Comment> getCommentByPageWithCTE(String gid, Integer pageNum, Integer pageSize);

    @Select("select cid from game_comment_like where uid = #{uid} and gid = #{gid}")
    List<String> queryLikedCommentIds(String uid, String gid);

    @Select("select count(*) from game_comment_like where uid =#{uid} and cid = #{cid}")
    int queryIsLikedComment(@PathVariable String uid, @PathVariable String cid);

    @Insert("insert into game_comment_like values(#{uid}, #{gid}, #{cid})")
    int doCommentLike(@PathVariable String uid,  @PathVariable String gid, @PathVariable String cid);

    @Delete("delete from game_comment_like where uid=#{uid} and cid=#{cid}")
    int disCommentLike(String uid, String cid);

    @Insert("insert into game_comment(uid, gid, ctime, `comment`) values(#{uid}, #{gid}, #{ctime}, #{comment})")
    int doComment(Comment comment);
}
