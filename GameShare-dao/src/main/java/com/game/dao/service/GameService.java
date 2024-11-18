package com.game.dao.service;

import com.game.common.utils.Result;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface GameService {

    //    @Override
//    public Result getDetails(String uid, String gid) {
//        Result result = Result.init();
//        // 1，用户 user
//        User user = userMapper.selectUserByUid(uid);
//        result.data("user", user);
//        // 2，游戏 game
//        Game game = gameMapper.selectById(gid);
//        result.data("game", game);
//        // 3，订单 order
//        Order order = orderMapper.selectByUidAndGid(uid, gid);
//        result.data("order", order);
//        // 4，该用户是否点赞 isLiked
//        boolean isLiked = gameMapper.queryIsLiked(uid, gid);
//        result.data("isLiked", isLiked);
//        // 5，该游戏点赞总数 likeNum
//        int likeNum = gameMapper.queryLikeNum(gid);
//        result.data("likeNum", likeNum);
//        return result.success(true).code(ResultCode.SUCCESS);
//    }
    Result getAllDetails(String uid, String gid);

    Result isLiked(String uid, String gid);
    Result doLike(String uid, String gid, String action);
    Result queryLikeNum(String gid);
    Result uploadGame(MultipartFile game);
    Resource downloadGame(String fileName);
    Result purchaseGame(String uid, String gid);

}
