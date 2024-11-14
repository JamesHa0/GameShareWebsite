package com.game.dao.service.impl;

import com.game.common.core.domain.entity.Game;
import com.game.common.core.domain.entity.Order;
import com.game.common.core.domain.entity.User;
import com.game.common.utils.FileHandler;
import com.game.common.utils.Result;
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

@Service
@Transactional  // 开启事务
public class GameServiceImpl implements GameService {

    @Value("${file.upload.dir}")
    private String FILE_UPLOAD_DIRECTORY;
    @Value("${file.download.dir}")
    private String FILE_DOWNLOAD_DIRECTORY; // 替换为你的文件存储路径

    @Autowired private UserMapper userMapper;
    @Autowired private GameMapper gameMapper;
    @Autowired private OrderMapper orderMapper;


    public Result like(String uid, String gid, String action) {
        if("like".equals(action) || "dislike".equals(action)){
            int affectedRows =  userMapper.updateGameLike(uid, gid, action);
            if(affectedRows > 0){
                return Result.ok().message("点赞成功");
            } else {
                return Result.error().message("点赞失败");
            }
        } else {
            System.err.println("action 不符合 like或dislike。action = " + action);
            return Result.error().message("action 不符合 like或dislike。action = " + action);
        }
    }

    /**
     * 查询某游戏的总获赞数（所有用户点赞的总数）
     */
    public Result queryGameLikeNum(String gid) {

        if(gid == null || !gid.matches("\\d+")){     // 验证一下gid是否规范
            throw new RuntimeException("【】gid参数不正确，考虑SQL注入的可能。gid = " + gid);
        }

        String json_column = "'" + "$.gid_" + gid + "'";     // 对json字段参数进行预处理，注意引号
        int affectedRows = userMapper.queryGameLikeNum("uliked_games",  json_column);
        if(affectedRows > 0){
            return Result.ok().data("likeNum", affectedRows);
        } else {
            return Result.error().message("查询失败");
        }
    }

    /**
     * 上传游戏文件
     * @param game 游戏本体文件
     * @return Result
     */
    public Result uploadGame(MultipartFile game) {
        System.err.println("待上传文件名：" + game.getOriginalFilename() +", 类型：" +game.getContentType() +", 上传地址：" +FILE_UPLOAD_DIRECTORY);

        FileHandler.saveFile(game, FILE_UPLOAD_DIRECTORY);
        return Result.ok().message("游戏上传成功");
    }

    /**
     * 下载游戏文件
     * @param fileName 文件名
     * @return Resource资源
     */
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
        if(user == null || game == null){
            return Result.error().message("用户或游戏不存在");
        }
        if(order != null){
            return Result.error().message("已存在该订单，您已购买过该游戏，无需再次购买");
        }
        if(user.getUpoint() < game.getGprice()){
            return Result.error().message("您的积分不足，无法购买该游戏");
        }

        // 扣除余额
        user.setUpoint(user.getUpoint() - game.getGprice());
        userMapper.deductPoint(uid, game.getGprice());

        // 添加订单（标识为购买成功）
        Order newOrder = new Order(uid, gid);
        orderMapper.insertOrder(newOrder);

        return Result.ok().message("购买成功。").data("order", newOrder);
    }
}
