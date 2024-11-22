package com.game.common.exception;

import com.game.common.utils.DateUtil;
//import com.google.gson.Gson;
import lombok.Data;

@Data
public class CommonClass {
//    Gson gson = new Gson();
    DateUtil dateUtil = new DateUtil();
}
