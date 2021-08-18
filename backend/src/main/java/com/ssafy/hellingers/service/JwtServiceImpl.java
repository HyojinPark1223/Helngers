package com.ssafy.hellingers.service;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;


@Service
public class JwtServiceImpl implements JwtService {

    private final String TK = "ASDFASDFLNNWELRNKLANSDFLKASDFNKLKLNASWERNLASDNKL";
    private final int EXPIRE_MINUTES = 60 * 60;

    @Override
    public <T> String create(String key, T data, String subject) {
        // jwt 빌더를 만들어주는 메소드
        System.out.println("!11111111111111111111111111111111111111111");
       String jwt = Jwts.builder().setHeaderParam("typ", "JWT")
                .setHeaderParam("regDate", System.currentTimeMillis())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * EXPIRE_MINUTES))
                .setSubject(subject)
                .claim(key, data)
                .signWith(SignatureAlgorithm.HS256, this.generateKey()).compact();
        System.out.println("222222222222222222222222222222222");
        return jwt;
    }

    private byte[] generateKey() {
        byte[] key = null;
        System.out.println("33333333333333333333333333333333333");
        try{
            key = TK.getBytes("utf-8");
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(key.toString());
        return key;
    }

    @Override
    public Map<String, Object> get(String key) {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String jwt = request.getHeader("access_token");
        Jws<Claims> claimsJws = null;

        try {
            claimsJws = Jwts.parser().setSigningKey(TK.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(jwt);
        }catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> value = claimsJws.getBody();
        return value;
    }

    @Override
    public String getUserId(String jwt) {
        Jws<Claims> claimsJws = null;

        try {
            Jws<Claims> claimsJws1 = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
        }catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> value = claimsJws.getBody();
        return (String) value.get("uid");
    }

    @Override
    public boolean isUsable(String jwt) {

        try{
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(this.generateKey())
                    .parseClaimsJws(jwt);
            // 이메일 검증 로직 작성
            // 토큰 만료시간 검증, 리프레시 토큰 (심화, 로그인 작성 이후에 도전)
            return true;
        }catch(ExpiredJwtException e) {   //Token이 만료된 경우 Exception이 발생한다.
            System.out.println("Token Expired");
            return false;

        }catch(JwtException e) {        //Token이 변조된 경우 Exception이 발생한다.
            System.out.println("Token Error");
            return false;
        }

    }

}