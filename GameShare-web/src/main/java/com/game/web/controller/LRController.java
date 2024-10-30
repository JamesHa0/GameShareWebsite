package com.game.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LRController {

    @PostMapping("/register")
    public String logout(){
        return "注册";
    }
}
