package com.ssafy.hellingers.controller;

import com.ssafy.hellingers.dto.UserDto;
import com.ssafy.hellingers.model.Role;
import com.ssafy.hellingers.model.User;
import com.ssafy.hellingers.service.EmailService;
import com.ssafy.hellingers.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;


@RestController
//따라서 엔드포인트에 도달하려면 api/user/**가 될 수 있습니다.
@RequestMapping("api/user")
public class UserController
{
    @Autowired
    private EmailService emailService;

    @Autowired
    private IUserService userService;

    //POST http://localhost:8080/api/user -data {user form}
    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid UserDto user) //@Valid provides validation check
    {
        if (userService.findByNickname(user.getNickname()) != null)
        {
            //Nickname 은 유니크해야
            return new ResponseEntity<>(HttpStatus.CONFLICT);//409
        }
        //dto를 모델 객체로 변환한 다음 서비스와 함께 저장합니다.
        userService.saveUser(user.convertToUser());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //GET http://localhost:8080/api/user/login -> 앞에서 설명한 보안 로그인 경로와 동일해야 합니다.
    //이것은 로그아웃 경로에도 사용됩니다. 로그 아웃 후 -> Spring은 로그인 경로로 리디렉션합니다.
    @GetMapping("/login")
    public ResponseEntity<?> login(HttpServletRequest request) //We can take it like also; Principal principal
    {
        //인증 정보는 Spring Security의 요청에 따라 저장됩니다.
        Principal principal = request.getUserPrincipal();
        if (principal == null || principal.getName() == null)
        {
            //여기에 로그아웃 리디렉션도 있으므로 OK로 간주합니다. httpStatus -> 오류가 없습니다.
            return new ResponseEntity<>(HttpStatus.OK);
        }
        User user = userService.findByNickname(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //PUT http://localhost:8080/api/user/{username}/change/{role}
    @PutMapping("{username}/change/{role}") //  POST, PATCH 로도 바꾸기 가능
    public ResponseEntity<?> changeRole(@PathVariable String username, @PathVariable Role role)
    {
        User user = userService.changeRole(role, username);
        return ResponseEntity.ok(user);
    }

    // POST http://localhost:8080/api/user/email/{email}/{code}
    // return값 없음.
    // 인증코드 보내기
    @PostMapping("/email/{email}/{code}")
    public void sendmail(@PathVariable String email, @PathVariable String code) throws MessagingException {
        StringBuffer emailcontent = new StringBuffer();
        System.out.println("들어오는 이메일:"+email);

        // 이메일로 보내질 html 형식의 내용들.
        emailcontent.append("<!DOCTYPE html>");
        emailcontent.append("<html>");
        emailcontent.append("<head>");
        emailcontent.append("</head>");
        emailcontent.append("<body>");
        emailcontent.append(
                " <div" 																																																	+
                        "	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #F8B75B; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">"		+
                        "	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"																															+
                        "		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">Helngers</span><br />"																													+
                        "		<span style=\"color: #F8B75B\">메일인증</span> 안내입니다."																																				+
                        "	</h1>\n"																																																+
                        "	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"																													+
                        "		Helngers에 가입해 주셔서 진심으로 감사드립니다.<br />"																																						+
                        "		아래 <b style=\"color: #F8B75B\">인증코드</b> 를 입력하여 회원가입을 완료해 주세요.<br />"																													+
                        "		감사합니다."																																															+
                        "	</p>"																																																	+
                        "	<a style=\"color: #9932CC; text-decoration: none; text-align: center;\""																																	+
                        "		<div"																																																	+
                        "			style=\"display: inline-block; width: 210px; height: 45px; margin: 30px 5px 40px; background: #F8B75B; line-height: 45px; vertical-align: middle; font-size: 16px;\">"							+
                        ""+code+"</div>"																																														+
                        "	</a>"																																																	+
                        "	<div style=\"border-top: 4px solid #F8B75B; padding: 5px;\"></div>"																																		+
                        " </div>"
        );
        emailcontent.append("</body>");
        emailcontent.append("</html>");

        emailService.sendMail(email, "[Helngers] 이메일 인증 요청", emailcontent.toString());
        System.out.println("이메일 보냄!");
    }
}
