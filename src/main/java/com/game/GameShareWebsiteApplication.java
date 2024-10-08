package com.game;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.game.mapper")		//声明扫描的mapper路径
public class GameShareWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameShareWebsiteApplication.class, args);
	}

}
