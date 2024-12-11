package com.game.dao.service.impl;

import com.game.common.utils.Result;
import com.game.dao.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl {
    @Autowired
    private OrderMapper orderMapper;

    public Result selectOrderAndItsGame(String uid) {
        return Result.ok().data("orderGames", orderMapper.selectOrderAndItsGame(uid));
    }
}
