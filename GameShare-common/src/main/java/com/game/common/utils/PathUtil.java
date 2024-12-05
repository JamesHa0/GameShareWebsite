package com.game.common.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {

    public static Path getCurrentProjectPath() {
        String userDir = System.getProperty("user.dir");
        return Paths.get(userDir);
    }

    public static Path getRootProjectPath(){
        Path currentPath = getCurrentProjectPath();
        while (!currentPath.getFileName().toString().equals("GameShare")){  // 向上取路径直到到达根目录GameShare
            currentPath = currentPath.getParent();
        }
        return currentPath;
    }

    public static Path getStoragePath(){
        return getRootProjectPath().resolve("storage");
    }

    public static Path getGameResourcePath(){
        return getStoragePath().resolve("game");
    }
}
