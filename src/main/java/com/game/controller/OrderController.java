package com.game.controller;

import com.game.entity.Order;
import com.game.mapper.OrderMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired private OrderMapper orderMapper;


    @GetMapping("/{uid}")
    @Operation(summary = "查询某用户的【全部】订单")
    public List<Order> listByUid(@PathVariable String uid) {
        return orderMapper.selectByUid(uid);
    }

    @GetMapping("/{uid}/{gid}")
    @Operation(summary = "查询某用户在某游戏的的【单个】订单")
    public Order listByUidAndGid(@PathVariable String uid, @PathVariable String gid){
        return orderMapper.selectByUidAndGid(uid,gid);
    }

    @GetMapping("listAllOrders")
    @Operation(summary = "查询【全部】订单")
    public List<Order> listAllOrders() {
        return orderMapper.selectList(null);
    }

    @GetMapping("/listAllOrdersAndItsUser")
    public List<Order> listAllOrdersAndItsUser() {
        return orderMapper.listAllOrdersAndItsUser();
    }
}
