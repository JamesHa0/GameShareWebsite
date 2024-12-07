package com.game.dao.service.impl;

import com.game.common.utils.DateUtil;
import com.game.common.utils.Result;
import com.game.common.utils.ResultCode;
import com.game.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public Result signIn(String uid) {
        String date = DateUtil.getDateNow();
        // 检查是否已签到
        if (userMapper.queryIsSignedIn(uid, date) > 0){
            return Result.error().code(ResultCode.CONFLICT).message("今日已签到").data("action", "signIn");
        }
        // 获取积分，并入库
        Float point = Float.valueOf(getWeightedPoint());
        userMapper.risePoint(uid, point);
        // 签到表中插入数据
        userMapper.insertSignIn(uid, date);
        return Result.ok().data("point", point);
    }

    private Integer getWeightedPoint(){
        List<Map<String,Object>> probabilityListMap = getProbabilityListMap();
        List<Float> cumulativeProbabilities = new ArrayList<>();    // 各积分概率的前缀和，用于模拟部分的逻辑
        for (int index = 0; index < probabilityListMap.size(); index++){
            Float probability = (Float) probabilityListMap.get(index).get("probability");
            if (index == 0) {
                cumulativeProbabilities.add(probability);
            } else {
                cumulativeProbabilities.add(probability + cumulativeProbabilities.get(index - 1));
            }
        }

        double randomNumber = new Random().nextDouble();
        for (int index = 0; index < cumulativeProbabilities.size(); index++) {
            Integer point = (Integer) probabilityListMap.get(index).get("point");
            if (randomNumber < cumulativeProbabilities.get(index)) {
                return point;
            }
        }

        return (Integer) probabilityListMap.get(probabilityListMap.size() - 1).get("point"); // 极端情况，返回最后一个分数
    }

    private static List<Map<String,Object>> getProbabilityListMap() {
        List<Map<String,Object>> listMap = new ArrayList<>();
        String key1 = "point";
        String key2 = "probability";
        listMap.add(Map.of(key1, 1, key2, 0.10F));    // 点数1的概率是0.05，以此类推
        listMap.add(Map.of(key1, 2, key2, 0.10F));
        listMap.add(Map.of(key1, 3, key2, 0.50F));
        listMap.add(Map.of(key1, 4, key2, 0.10F));
        listMap.add(Map.of(key1, 5, key2, 0.10F));    // 前90%
        listMap.add(Map.of(key1, 7, key2, 0.03F));
        listMap.add(Map.of(key1, 9, key2, 0.03F));
        listMap.add(Map.of(key1, 10, key2, 0.03F));   // 前99%
        listMap.add(Map.of(key1, 66, key2, 0.005F));
        listMap.add(Map.of(key1, 99, key2, 0.005F));  // 前100%
        return listMap;
    }
}
