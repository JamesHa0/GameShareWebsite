package com.game.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.game.common.core.domain.entity.Game;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GameMapper extends BaseMapper<Game> {
    /**
     * like相关的方法
     * @description 1，查询是否点过赞
     * @description 2，查询赞数
     * @description 3，点赞/4，取消点赞
     */
    @Select("select count(*) from game_like where uid = ${uid} and gid = ${gid}")
    int queryIsLiked(String uid, String gid);

    @Select("select count(*) from game_like where gid = ${gid}")
    int queryLikeNum(@RequestParam String gid);

    @Insert("insert game_like values(${uid},${gid})")
    int doLike(@RequestParam String uid, @RequestParam String gid);

    @Delete("delete from game_like where uid = ${uid} and gid = ${gid}")
    int disLike(@RequestParam String uid, @RequestParam String gid);

}
