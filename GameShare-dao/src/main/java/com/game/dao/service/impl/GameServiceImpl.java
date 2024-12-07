package com.game.dao.service.impl;

import com.game.common.core.domain.entity.Game;
import com.game.common.core.domain.entity.Order;
import com.game.common.core.domain.entity.User;
import com.game.common.utils.FileUtil;
import com.game.common.utils.PathUtil;
import com.game.common.utils.Result;
import com.game.common.utils.ResultCode;
import com.game.dao.mapper.CommentMapper;
import com.game.dao.mapper.GameMapper;
import com.game.dao.mapper.OrderMapper;
import com.game.dao.mapper.UserMapper;
import com.game.dao.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

@Service
@Transactional  // 开启事务
public class GameServiceImpl implements GameService {

    private final Path FILE_UPLOAD_DIRECTORY = PathUtil.getGameResourcePath();
    private final Path FILE_DOWNLOAD_DIRECTORY = FILE_UPLOAD_DIRECTORY;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GameMapper gameMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 获取detail页面所需数据
     * @param uid uid
     * @param gid gid
     * @return Result(): user, game, order, isLiked, likeNum, likedCids, commentNum
     */
    @Override
    public Result getAllDetails(String uid, String gid) {
        Result result = Result.init();
        // 1，用户 user
        User user = userMapper.selectUserByUid(uid);
        result.data("user", user);
        // 2，游戏 game
        Game game = gameMapper.selectById(gid);
        result.data("game", game);
        // 2-1，该用户是否给该游戏点赞 isLiked
        boolean isLiked = gameMapper.queryIsLiked(uid, gid) > 0;
        result.data("isLiked", isLiked);
        // 2-2，该游戏点赞总数 likeNum
        int likeNum = gameMapper.queryLikeNum(gid);
        result.data("likeNum", likeNum);
        // 3，订单 order
        Order order = orderMapper.selectByUidAndGid(uid, gid);
        result.data("order", order);
        // 4，该用户在该游戏的评论中点过赞的评论id集合 list<cid>
        List<String> likedCids = commentMapper.queryLikedCommentIds(uid, gid);
        result.data("likedCids", likedCids);
        // 4-1，该游戏评论数 commentNum
        Integer commentNum = commentMapper.queryCommentNumByGid(gid);
        result.data("commentNum", commentNum);
        return result.success(true).code(ResultCode.SUCCESS);
    }



    /**
     * 点赞业务
     * @param uid 用户id
     * @param gid 游戏id
     * @return Result
     */
    public Result doLike(String uid, String gid) {
        String action;
        if (gameMapper.queryIsLiked(uid, gid) == 0){   // 记录中没有数据，故进行点赞操作
            action = "doLike";
            if (gameMapper.doLike(uid, gid) > 0) {
                return Result.ok().message("点赞成功").data("action", action);
            }
        } else {
            action = "disLike";
            if (gameMapper.disLike(uid, gid) > 0){
                return Result.ok().message("取消点赞成功").data("action", action);
            }
        }
        return Result.error().message("点赞或取消赞操作失败").data("action", action);
    }



    /**
     * 文件相关业务
     * @description 1，下载文件
     * @description 2，上传文件
     */
    public Result uploadGame(MultipartFile game) {
        System.out.println("【上传】待上传文件名：" + game.getOriginalFilename() +", 类型：" +game.getContentType() +", 上传地址：" +FILE_UPLOAD_DIRECTORY);

        FileUtil.saveFile(game, FILE_UPLOAD_DIRECTORY);
        return Result.ok().message("游戏上传成功");
    }

    public Resource downloadGame(String fileName) {
        System.out.println("【下载】准备下载文件：" + fileName +",地址：" + FILE_DOWNLOAD_DIRECTORY);

        return FileUtil.downloadFile(fileName, FILE_DOWNLOAD_DIRECTORY);
    }


    /**
     * 购买游戏业务
     * @param uid 用户id
     * @param gid 游戏 id
     * @return Result
     */
    public Result purchaseGame(String uid, String gid) {
        // 检查订单、积分、价格等
        User user = userMapper.selectUserByUid(uid);
        Game game = gameMapper.selectById(gid);
        Order order = orderMapper.selectByUidAndGid(uid, gid);
        System.out.println("order="+order);
        if(user == null || game == null)
            return Result.error().message("用户或游戏不存在");
        if(order != null)
            return Result.error().message("已存在该订单，您已购买过该游戏，无需再次购买");
        if(user.getUpoint() < game.getGprice())
            return Result.error().message("您的积分不足，无法购买该游戏");
        // 扣除余额
        userMapper.deductPoint(uid, game.getGprice());
        // 添加订单（标识为购买成功）
        orderMapper.insertOrder(new Order(uid, gid));

        return Result.ok().message("购买成功。");
    }
}
