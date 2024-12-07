package com.game.web.controller;

import com.game.common.core.domain.entity.Game;
import com.game.common.utils.Result;
import com.game.dao.mapper.GameMapper;
import com.game.dao.service.impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired private GameMapper gameMapper;
    @Autowired private GameServiceImpl gameServiceImpl;


    /**
     * 获取detail页面所需数据
     * @param uid uid
     * @param gid gid
     * @return Result(): user, game, order, isLiked, likeNum
     */
    @GetMapping("/details/{uid}/{gid}")
    public Result getAllDetails(@PathVariable String uid, @PathVariable String gid) {
        return gameServiceImpl.getAllDetails(uid, gid);
    }

    /**
     * 点赞业务
     * @param uid uid
     * @param gid gid
     */
    @PostMapping("/doLike")  // 1，用户id；2，游戏id；3，指定点赞还是取消点赞；
    public Result doLike(@RequestParam String uid, @RequestParam String gid) {
        return gameServiceImpl.doLike(uid, gid);
    }

    /**
     * 文件相关
     * @description 1，下载文件
     * @description 2，上传文件
     */
    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        Resource resource = gameServiceImpl.downloadGame(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @PostMapping("/upload")
    public Result upload(MultipartFile game) {
        return gameServiceImpl.uploadGame(game);
    }

    /**
     * 购买业务
     * @description 购买游戏
     */
    @PostMapping("/purchase/{uid}/{gid}")
    public Result purchaseGame(@PathVariable String uid, @PathVariable String gid){
        return gameServiceImpl.purchaseGame(uid, gid);
    }


}
