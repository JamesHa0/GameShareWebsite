package com.game.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.game.common.core.domain.entity.Comment;
import com.game.common.core.domain.entity.Game;
import com.game.common.core.domain.entity.Order;
import com.game.common.core.domain.entity.User;
import com.game.common.utils.FileHandler;
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

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Transactional  // 开启事务
public class GameServiceImpl implements GameService {

    @Value("${file.upload.dir}")
    private String FILE_UPLOAD_DIRECTORY;
    @Value("${file.download.dir}")
    private String FILE_DOWNLOAD_DIRECTORY; // 替换为你的文件存储路径

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
     * @return Result(): user, game, order, isLiked, likeNum
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
//        // 4，评论 comment
//        List<Comment> comments = selectCommentByPage(gid, 1, 10);
//        result.data("comments", comments);
        // 4-1，该用户在该游戏的评论中点过赞的评论id集合 list<cid>
        List<String> likedComments = commentMapper.queryLikedComments(uid, gid);
        result.data("likedComments", likedComments);
        // 4-2，该游戏评论数 commentNum
        Integer commentNum = commentMapper.queryCommentNumByGid(gid);
        result.data("commentNum", commentNum);
        return result.success(true).code(ResultCode.SUCCESS);
    }



    /**
     * 点赞业务
     * @param uid 用户id
     * @param gid 游戏id
     * @param action 点赞/取消点赞
     * @return Result
     */
    public Result doLike(String uid, String gid, String action) {
        if("like".equals(action)){
            if(gameMapper.doLike(uid, gid) > 0) {
                return Result.ok().message("点赞成功");
            }
        }else if("dislike".equals(action)){
            if(gameMapper.disLike(uid, gid) > 0){
                return Result.ok().message("取消点赞成功");
            }
        } else {
            System.err.println("action 不符合 like或dislike。action = " + action);
            return Result.error().message("action 不符合 like或dislike。action = " + action);
        }
        return Result.error().message("点赞/取消点赞操作失败");
    }



    /**
     * 文件相关业务
     * @description 1，下载文件
     * @description 2，上传文件
     */
    public Result uploadGame(MultipartFile game) {
        System.err.println("待上传文件名：" + game.getOriginalFilename() +", 类型：" +game.getContentType() +", 上传地址：" +FILE_UPLOAD_DIRECTORY);

        FileHandler.saveFile(game, FILE_UPLOAD_DIRECTORY);
        return Result.ok().message("游戏上传成功");
    }

    public Resource downloadGame(String fileName) {
        System.err.println("准备下载文件：" + fileName +",地址：" + FILE_DOWNLOAD_DIRECTORY);

        return FileHandler.downloadFile(fileName, FILE_DOWNLOAD_DIRECTORY);
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
        Order newOrder = new Order(uid, gid);
        orderMapper.insertOrder(new Order(uid, gid));

        return Result.ok().message("购买成功。").data("order", newOrder);
    }
}
