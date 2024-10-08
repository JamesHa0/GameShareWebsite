package com.game.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

//统一返回结果的类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private boolean success ;

    private Integer code;

    private String message;

    private Map<String,Object> data = new HashMap<>();

    public Result(boolean success, Integer code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }


    public static Result ok() {
        return new Result(true,ResultCode.SUCCESS,"success");
    }

    public static Result error() {
        return new Result(false,ResultCode.ERROR,"error");
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }

    public Result data(String key,Object value) {
        this.data.put(key,value);
        return this;
    }
    public Result data(Map<String,Object> map ) {
        this.setData(map);
        return this;
    }
}
