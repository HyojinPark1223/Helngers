package com.ssafy.hellingers.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
public class LoginData {
    Long user_id;
    String token;

    public LoginData(Long id, String token){
        this.user_id = id;
        this.token = token;
    }
}