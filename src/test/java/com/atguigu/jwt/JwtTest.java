package com.atguigu.jwt;

import com.atguigu.jwt.entity.Member;
import com.atguigu.jwt.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

/**
 * @author Tituo
 * @create 2020-03-03
 */
public class JwtTest {


    @Test
    public void testGenerateJWT(){

        Member member = new Member();

        member.setId("1");
        member.setNickname("Tituo");
        member.setAvatar("头像.jpg");

        String jwt = JwtUtils.GenerateJWT(member.getId(), member.getNickname(), member.getAvatar());
        System.out.println(jwt);
    }


    @Test
    public void testCheckJWT(){
        Claims claims = JwtUtils.checkJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJndWxpLXVzZXIiLCJpYXQiOjE1ODMyNDM3NDgsImV4cCI6MTU4MzI0NTU0OCwiaWQiOiIxIiwibmlja25hbWUiOiJUaXR1byIsImF2YXRhciI6IuWktOWDjy5qcGcifQ.scRhmvaK8NSbWedzL1xgp0dBXp6oTss24jY00nb2hfk");
        String id = (String)claims.get("id");
        String nickname = (String)claims.get("nickname");
        String avatar = (String)claims.get("avatar");

        System.out.println(id);
        System.out.println(nickname);
        System.out.println(avatar);
    }
}
