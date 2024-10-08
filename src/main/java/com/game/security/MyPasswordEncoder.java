package com.game.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder implements PasswordEncoder {
    /**
     * 对密码进行加密
     * @param rawPassword
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return new BCryptPasswordEncoder(4).encode(rawPassword);
    }


    /**
     * 验证密码是否正确
     * @param rawPassword，明文，是登陆时客户端传递的
     * @param encodedPassword，密文，是服务器中存储的
     * @return
     */

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return PasswordEncoder.super.upgradeEncoding(encodedPassword);
    }
}
