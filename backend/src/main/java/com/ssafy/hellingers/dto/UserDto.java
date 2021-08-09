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
    private String email;

    @NotBlank
    private String nickname;

    @NotBlank
    private String password;

    @NotBlank
    private String introduce;


    private Long id;
    private String categories;
    private int count;
    private int comment_count;
    private int level;
    private int point;
    private int period;
    private int purpose;



    public User convertToUser()
    {
        User user = new User();
        user.setEmail(email);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setIntroduce(introduce);
        return user;
    }
}
