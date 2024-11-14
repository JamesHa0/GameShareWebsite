package com.game.dao.service;

import com.game.common.utils.Result;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface GameService {
    public Result like(String uid, String gid, String action);
    public Result queryGameLikeNum(String gid);
    public Result uploadGame(MultipartFile game);
    public Resource downloadGame(String fileName);
    public Result purchaseGame(String uid, String gid);
}
