package com.game.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.game"})		// 扫描全部包，解决异模块报Bean未声明的错误
@MapperScan("com.game")		//声明扫描的mapper路径
public class GameShareWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameShareWebsiteApplication.class, args);
	}

}
