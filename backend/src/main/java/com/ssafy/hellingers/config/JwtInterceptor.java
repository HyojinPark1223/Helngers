package com.ssafy.hellingers.config;

import com.ssafy.hellingers.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final String HEADER_AUTH = "access_token";

    @Autowired
    private JwtService jwtService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals("OPTIONS")) {
            return true;
        }else {
            //GET, POST, UPDATE, DELETE 요청은 권한 체크
            String token = request.getHeader(HEADER_AUTH);
            if(token != null || jwtService.isUsable(token)){
                return true;
            }else{
                System.out.println("토큰이 사용 불가능 합니다.");
            }
        }

        return false;
    }
}