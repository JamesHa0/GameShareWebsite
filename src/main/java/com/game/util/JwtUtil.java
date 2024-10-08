package com.game.util;

import com.game.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.*;

@Component
public class JwtUtil {
    private static final String TOKEN_SECRET = "a1b2c3d4e5f6a1b2c3d4e5f6a1b2c3d4e5f6a1b2c3d4e5f6";  //32位原始字符串
    private static final Key signingKey = new SecretKeySpec(TOKEN_SECRET.getBytes(), SignatureAlgorithm.HS256.getJcaName());  //密钥

    public static String generateToken(String sub, HashMap<String, String> claims){
        Date now = new Date();
        //7天有效期
        long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;
        Date expiration = new Date(now.getTime() + EXPIRE_TIME);

        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("type","JWT")   //Header
                .setSubject(sub)     // 将用户的 id 作为 JWT 的主题
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(signingKey, SignatureAlgorithm.HS256);     //加密算法
                Set<String> sets = claims.keySet();
                for(String i : sets){
                    builder.claim(i, claims.get(i));
                }

        return builder.compact();     //合成
    }


    // 解析 JWT
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey) // 设置密钥
                .build()
                .parseClaimsJws(token)       // 解析 JWT
                .getBody();                  // 获取 Claims
    }


    // 校验JWT
    public static Result validateJWT(String token) {
        try {
            Claims claims =parseToken(token);
            if (claims.getExpiration().before(new Date())) {
                return Result.error().message("token已过期");
            }
            Map<String, Object> data = new HashMap<>();
            data.put("uid",claims.getSubject());
            return Result.ok().message("token验证成功").data(data);
        } catch (Exception e) {
            return Result.error().message("token验证失败");
        }
    }
}
