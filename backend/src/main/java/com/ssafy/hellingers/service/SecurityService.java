package com.ssafy.hellingers.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Locale;

@Service
public class SecurityService {
    private static final String SECRET_KEY = "asdfsfadfasdasdasdacszzxvwefewfaegsdoifjweiofjlknvjklznvkzxczxc";

    //로그인 서비스 던질 때 같이 ~
    public String createToken(String subject, long expTime) {
        if(expTime<=0) {
            throw new RuntimeException("만료시간이 0보다 커야함~");
        }
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .setSubject(subject)
                .signWith(signingKey, signatureAlgorithm)
                .setExpiration(new Date(System.currentTimeMillis() + expTime))
                .compact();

    }

    //토큰 검증하는 메서드를 만들어서 boolean 타입으로 리턴 해주는걸 써서 실제로 토큰을 검증하는 로직에서 메소드를 복제해서 사용
    public String getSubject(String token) {
        //Claims = payload에 담기는 정보
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .build()
                .parseClaimsJws(token) // 토큰을 넣어서 풀어주는 코드
                .getBody(); // 풀어줬으니 getBody로 claims를 가져옴

        return claims.getSubject();
    }
}