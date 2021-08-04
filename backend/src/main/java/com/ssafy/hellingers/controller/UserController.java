package com.ssafy.hellingers.controller;

import com.ssafy.hellingers.dto.UserDto;
import com.ssafy.hellingers.model.Role;
import com.ssafy.hellingers.model.User;
import com.ssafy.hellingers.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;


@RestController
//따라서 엔드포인트에 도달하려면 api/user/**가 될 수 있습니다.
@RequestMapping("api/user")
public class UserController
{
    @Autowired
    private IUserService userService;

    //POST http://localhost:8080/api/user -data {user form}
    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid UserDto user) //@Valid provides validation check
    {
        if (userService.findByUsername(user.getUsername()) != null)
        {
            //Username 은 유니크해야
            return new ResponseEntity<>(HttpStatus.CONFLICT);//409
        }
        //dto를 모델 객체로 변환한 다음 서비스와 함께 저장합니다.
        userService.saveUser(user.convertToUser());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //GET http://localhost:8080/api/user/login -> 앞에서 설명한 보안 로그인 경로와 동일해야 합니다.
    //이것은 로그아웃 경로에도 사용됩니다. 로그 아웃 후 -> Spring은 로그인 경로로 리디렉션합니다.
    @GetMapping("login")
    public ResponseEntity<?> login(HttpServletRequest request) //We can take it like also; Principal principal
    {
        //인증 정보는 Spring Security의 요청에 따라 저장됩니다.
        Principal principal = request.getUserPrincipal();
        if (principal == null || principal.getName() == null)
        {
            //여기에 로그아웃 리디렉션도 있으므로 OK로 간주합니다. httpStatus -> 오류가 없습니다.
            return new ResponseEntity<>(HttpStatus.OK);
        }
        User user = userService.findByUsername(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //PUT http://localhost:8080/api/user/{username}/change/{role}
    @PutMapping("{username}/change/{role}") //  POST, PATCH 로도 바꾸기 가능
    public ResponseEntity<?> changeRole(@PathVariable String username, @PathVariable Role role)
    {
        User user = userService.changeRole(role, username);
        return ResponseEntity.ok(user);
    }
}
