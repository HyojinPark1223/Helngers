package com.ssafy.hellingers.dto;

import com.ssafy.hellingers.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter //여기서는  setter 필요 x
@NoArgsConstructor //생성자 생성
public class UserDto //Data Transfer Object
{
    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private String password;


    private Long id;
    private String email;
    private String nickname;
    private String categories;
    private int count;
    private int comment_count;
    private int level;
    private String introduce;
    private int point;
    private int dead;
    private int squat;
    private int bench;



    public User convertToUser()
    {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
