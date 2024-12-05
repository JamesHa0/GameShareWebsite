package com.game.web;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class GetRealPath {

    @Test
    public void test(){
        String userDir = System.getProperty("user.dir");
        Path currentPath = Paths.get(userDir);
        System.out.println(currentPath.getFileName());
        while (!currentPath.getFileName().toString().equals("GameShare")){
            currentPath = currentPath.getParent();
        }
        System.out.println(currentPath);
//        Path gamePath = currentPath.resolve("storage/game");
//        System.out.println(
//                gamePath
//        );
    }
}
