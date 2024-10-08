package com.game;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class GameShareWebsiteApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("hello world");
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
		System.out.println(passwordEncoder.encode("12345678901"));
		System.out.println(passwordEncoder.encode("12121212121"));
		System.out.println(passwordEncoder.encode("10000000188"));
		System.out.println(passwordEncoder.encode("10000000196"));
	}

}
