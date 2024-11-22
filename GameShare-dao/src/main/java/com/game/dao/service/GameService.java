package com.game.dao.service;

import com.game.common.utils.Result;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface GameService {

    Result getAllDetails(String uid, String gid);
    Result doLike(String uid, String gid, String action);
    Result uploadGame(MultipartFile game);
    Resource downloadGame(String fileName);
    Result purchaseGame(String uid, String gid);

}
