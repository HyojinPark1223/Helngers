package com.ssafy.hellingers.controller;

import com.ssafy.hellingers.dto.FollowDto;
import com.ssafy.hellingers.dto.UserDto;
import com.ssafy.hellingers.model.LoginData;
import com.ssafy.hellingers.model.Role;
import com.ssafy.hellingers.model.User;
import com.ssafy.hellingers.service.EmailService;
import com.ssafy.hellingers.service.FollowServiceImpl;
import com.ssafy.hellingers.service.RandomPickService;
import com.ssafy.hellingers.service.UserService;
import com.ssafy.hellingers.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;


@RestController
//따라서 엔드포인트에 도달하려면 api/user/**가 될 수 있습니다.
@RequestMapping("/")
public class UserController
{
    @Autowired
    private FollowServiceImpl followsvc;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @Autowired
    RandomPickService randomPickService;

    @Autowired
    JwtService jwtService;

    // 운동 경력이 들어가는 API (POST)
    // 운동 목적이 들어가는 API (POST)


    //POST http://localhost:8080/api/user -data {user form}
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto user) throws Exception //@Valid provides validation check
    {
        if(userService.findByEmail(user.getEmail()) != null) {

            // Email 은 유니크해야
            return new ResponseEntity<>("EMAIL_ERROR",HttpStatus.CONFLICT);//409
        }
        if (userService.findByNickname(user.getNickname()) != null) {

            //Nickname은 유니크해야
            return new ResponseEntity<>("NICKNAME_ERROR", HttpStatus.CONFLICT);//409
        }

        //dto를 모델 객체로 변환한 다음 서비스와 함께 저장합니다.
        userService.saveUser(user.convertToUser());

        String temp = user.getEmail();
        System.out.println(temp);
        User returnUser =  userService.findByEmail(temp);

        // 회원가입을 하면서부터 메달리스트는 배정하고 시작
        randomPickService.insertMedalstoUser(returnUser.getId());

        return new ResponseEntity<>(returnUser, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request) //We can take it like also; Principal principal
    {
        try {
            Optional<User> loginUser = userService.login(user.getEmail(), user.getPassword());
            String jwt = jwtService.create("email", user.getEmail(), "access_token");

            LoginData loginData = new LoginData(loginUser.get().getId(),jwt);
            return new ResponseEntity<>(loginData, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("ID_OR_PASSWORD_WRONG", HttpStatus.NOT_FOUND);

        // 이메일 비밀번호 검증 과정

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
                        "		안녕하세요, Helngers에 가입해 주셔서 진심으로 감사드립니다.<br />"																																						+
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

    @PostMapping(value ="follow")
    public FollowDto follow(@RequestBody FollowDto followDto) throws Exception {
        int from_id = followDto.getFrom_id();
        int to_id = followDto.getTo_id();

        System.out.println("****잘 돌아가는지 확인용, from_id:" + from_id);
        System.out.println("****잘 돌아가는지 확인용, to_id:" + to_id);
        // 맞팔을 했는지 체크.(맞팔을 안했음 0이 나올 것)
        int check = followsvc.checkFollows(followDto);
        System.out.println("****잘 돌아가는지 확인용(check값):" + check);
        if(check>0){ // 상대가 나를 팔로우 하고 있다면,
            // follows = 1로 들어갈 것.
            followsvc.willFollows(followDto);

            // 상대의 기존 follows 상태도 1로 변경해줘야함.
            followsvc.updateFollows(followDto);

            followDto.setFollows(true);

        }else{ // 상대가 나를 팔로우 한 상태가 아닐 때,
            followsvc.onewayFollows(followDto);
        }

        System.out.println("****return 되는 dto 확인확인!!!:"+followDto.toString());
        return followDto;
    }


    // 내가(유저) 팔로우를 취소.
    @PostMapping(value = "unfollow")
    public FollowDto unfollow(@RequestBody FollowDto followDto) throws Exception{
        int from_id = followDto.getFrom_id();
        int to_id = followDto.getTo_id();

        System.out.println("****잘 돌아가는지 확인용, from_id:" + from_id);
        System.out.println("****잘 돌아가는지 확인용, to_id:" + to_id);

        int check = followsvc.checkFollows(followDto);

        System.out.println("****잘 돌아가는지 확인용, check:" + check);

        // 만약 서로 맞팔 상태라면 check = 1(true)이 들어가 있을 것.
        if(check>0){ // 맞팔인데 팔로우 끊으면,
            // 나는 삭제가 되고, 상대는 맞팔 처리가 되어있을 것이므로 수정해준다.
            followsvc.deleteFollows(followDto);
            System.out.println("둘이 맞팔상태였음! delete로직 돌아가는 중...");
        }
        followsvc.unfollow(followDto);

        System.out.println("****return 되는 dto 확인확인!!!:"+followDto.toString());
        return followDto;
    }

    // 팔로잉 리스트
    @PostMapping(value = "following/{from_id}")
    public List<FollowDto> following(@PathVariable int from_id) throws Exception{
        System.out.println("****from_id:"+from_id);

        List<FollowDto> following = new ArrayList<>();

        following = followsvc.followingList(from_id);

        return following;
    }

    // 팔로워 리스트
    @PostMapping(value = "follower/{to_id}")
    public List<FollowDto> follower(@PathVariable int to_id) throws Exception{
        System.out.println("****to_id:"+to_id);
        List<FollowDto> follower = new ArrayList<>();
        follower = followsvc.followerList(to_id);

        return follower;
    }

}
