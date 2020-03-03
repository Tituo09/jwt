package com.atguigu.jwt.util;

import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @author Tituo
 * @create 2020-03-03
 */
public class JwtUtils {

    /**
     * jwt主题
     */
    public static final String SUBJECT = "guli-user";

    /**
     * 秘钥
     */
    public static final String APP_SECRET = "khKuKD0KpBirnss55WAYphaoj6ghm0";

    /**
     * 过期时间
     */
    public static final long EXPIRE = 1000 * 60 * 30;


    /**
     * 生成JWT令牌
     * @param id
     * @param nickname
     * @param avater
     * @return
     */
    public static String GenerateJWT(String id, String nickname, String avater){

        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                //签名算法
                .setHeaderParam("alg", "HS256")
                //默认有效载荷
                .setSubject(SUBJECT)
                //签发时间
                .setIssuedAt(new Date())
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //自定义有效载荷
                .claim("id", id)
                .claim("nickname", nickname)
                .claim("avatar", avater)
                //签名哈希
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return token;
    }


    public static Claims checkJWT(String jwtToken){

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);

        String signature = claimsJws.getSignature();
        System.out.println(signature);

        JwsHeader header = claimsJws.getHeader();
        Claims body = claimsJws.getBody();
        return body;
    }

}
