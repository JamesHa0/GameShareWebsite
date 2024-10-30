package com.game.web.controller;

import com.game.common.core.domain.entity.Game;
import com.game.dao.mapper.GameMapper;
import com.game.dao.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired private GameMapper gameMapper;
    @Autowired private GameService gameService;

    @GetMapping("/{gid}")
    public Game listOneGame(@PathVariable String gid) {
        return gameMapper.selectById(gid);
    }

    @GetMapping("/AllGames")
    public List<Game> listAllGames() {
        return gameMapper.selectList(null);
    }

    @PostMapping("/like")  // 1，用户id；2，游戏id；3，指定点赞还是取消点赞；
    public int doLike(@RequestParam String uid, @RequestParam String gid, @RequestParam String action) {
        return gameService.like(uid, gid, action);
    }

    @GetMapping("/likeNum/{gid}")
    public int queryGameLikeNum(@PathVariable String gid) {
        return gameService.queryGameLikeNum(gid);
    }
}
