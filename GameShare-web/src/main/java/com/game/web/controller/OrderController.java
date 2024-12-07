package com.game.web.controller;

import com.game.common.core.domain.entity.Order;
import com.game.common.utils.Result;
import com.game.dao.mapper.OrderMapper;
//import io.swagger.v3.oas.annotations.Operation;
import com.game.dao.service.impl.OrderServiceImpl;
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

    @Autowired private OrderServiceImpl orderService;

    @GetMapping("/orderGame/{uid}")
    public Result selectOrderAndItsGame(@PathVariable() String uid) {
        return orderService.selectOrderAndItsGame(uid);
    }


//    @GetMapping("/{uid}")
//    @Operation(summary = "查询某用户的全部订单")
//    public List<Order> listByUid(@PathVariable String uid) {
//        return orderMapper.selectByUid(uid);
//    }

//    @GetMapping("/{uid}/{gid}")
//    @Operation(summary = "查询某用户在某游戏的的单个订单")
//    public Order listByUidAndGid(@PathVariable String uid, @PathVariable String gid){
//        return orderMapper.selectByUidAndGid(uid,gid);
//    }

//    @GetMapping("listAllOrders")
//    @Operation(summary = "查询全部订单")
//    public List<Order> listAllOrders() {
//        return orderMapper.selectList(null);
//    }
//
//    @GetMapping("/listAllOrdersAndItsUser")
//    public List<Order> listAllOrdersAndItsUser() {
//        return orderMapper.listAllOrdersAndItsUser();
//    }
}
