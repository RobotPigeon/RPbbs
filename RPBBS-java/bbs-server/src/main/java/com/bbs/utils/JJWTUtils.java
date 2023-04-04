package com.bbs.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

public class JJWTUtils {

    // 有效期
    public static final Long JWT_TTL = 3600000L;

    // JWT令牌信息
    public static final String JWT_KEY = "RP!@#123";

    /**
     * 创建jwt token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        if (ttlMillis == null) {
            ttlMillis = JWT_TTL;
        }

        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);

        SecretKey secretKey = generalKey();

        JwtBuilder builder = Jwts.builder()
                .setId(id)                      // 设置唯一编号
                .setSubject(subject)            // 设置主题 可以是JSON数据
                .setIssuedAt(now)               // 设置签发日期
                .setExpiration(expDate)         // 设置过期时间
                // 设置签名 使用HS256算法 并设置SecretKey(字符串)
                .signWith(SignatureAlgorithm.HS256, secretKey);

        return builder.compact();
    }

    public static String createJWT(Map<String, Object> map, Long ttlMillis) {
        SecretKey secretKey = generalKey();

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        if (ttlMillis == null) {
            ttlMillis = JWT_TTL;
        }

        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);

        JwtBuilder builder = Jwts.builder()
                .setClaims(map)
                .setIssuedAt(now)               // 设置签发日期
                .setExpiration(expDate)         // 设置过期时间
                .signWith(SignatureAlgorithm.HS256, secretKey);

        return  builder.compact();
    }

    /**
     * 解析令牌数据
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    /**
     * 生成加密secretKey
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getEncoder().encode(JWT_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
}

