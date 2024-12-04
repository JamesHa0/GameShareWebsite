package com.game.web;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GetWeightedPointClass {

    @Test
    public void test(){
        Map<Integer, Integer> pointList = new HashMap<>();
        Map<Integer, Float> probabilities = new HashMap<>();
        Double num = 10000.0;
        for (int i = 0; i < num; i++){
            Integer point = getWeightedPoint();
            if (pointList.containsKey(point)){
                pointList.put(point, pointList.get(point) + 1);
            } else {
                pointList.put(point, 1);
            }
//            System.out.println(getWeightedPoint());
        }

        for (Map.Entry<Integer, Integer> entry : pointList.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue()/num);
        }
    }


    private Integer getWeightedPoint(){
        List<Map<String,Object>> probabilityListMap = getProbabilityMap();
        List<Float> cumulativeProbabilities = new ArrayList<>();    // 各积分概率的前缀和，用于模拟部分的逻辑
        for (int index = 0; index < probabilityListMap.size(); index++){
            // Integer point = (Integer) probabilityListMap.get(index).get("point");
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
            // Float probability = (Float) probabilityListMap.get(index).get("probability");
            if (randomNumber < cumulativeProbabilities.get(index)) {
                return point;
            }
        }

        return (Integer) probabilityListMap.get(probabilityListMap.size() - 1).get("point"); // 极端情况，返回最后一个分数
    }

    private static List<Map<String,Object>> getProbabilityMap() {
        List<Map<String,Object>> listMap = new ArrayList<>();
//        Map<String,Object> map1 = new HashMap<String,Object>();
//        map1.put("point", 1);
//        map1.put("probability", 0.10F);
//        listMap.add(map1);
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
//        Map<Integer, Float> probabilities = new HashMap<>();
//        probabilities.put(1, 0.10F);
//        probabilities.put(2, 0.10F);
//        probabilities.put(3, 0.50F);
//        probabilities.put(4, 0.10F);
//        probabilities.put(5, 0.10F);
//        probabilities.put(7, 0.03F);
//        probabilities.put(9, 0.03F);
//        probabilities.put(10, 0.03F);
//        probabilities.put(66, 0.005F);
//        probabilities.put(99, 0.005F);
        return listMap;
    }
}
