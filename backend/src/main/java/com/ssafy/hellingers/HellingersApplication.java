package com.ssafy.hellingers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HellingersApplication {
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        //암호화되고 안전한 암호를 생성
//        return new BCryptPasswordEncoder();
//    }
    public static void main(String[] args) {
        SpringApplication.run(HellingersApplication.class, args);
    }

}
