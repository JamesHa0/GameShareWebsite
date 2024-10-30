package com.game.dao.service;

import com.game.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired private UserMapper userMapper;

    public int like(String uid, String gid, String action) {
        if("like".equals(action) || "dislike".equals(action)){
            return userMapper.updateGameLike(uid, gid, action);
        } else {
            System.err.println("action 不符合 like或dislike。action = " + action);
            return 0;
        }
    }

    /**
     * 查询某游戏的总获赞数（所有用户点赞的总数）
     */
    public int queryGameLikeNum(String gid) {

        if(gid == null || !gid.matches("\\d+")){     // 验证一下gid是否规范
            throw new RuntimeException("【】gid参数不正确，考虑SQL注入的可能。gid = " + gid);
        }

        String json_column = "'" + "$.gid_" + gid + "'";     // 对json字段参数进行预处理，注意引号
        return userMapper.queryGameLikeNum("uliked_games",  json_column);
    }


}
