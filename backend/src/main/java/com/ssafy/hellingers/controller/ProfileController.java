package com.ssafy.hellingers.controller;//package com.ssafy.hellingers.controller;
//
//import com.ssafy.hellingers.model.Medal;
//import com.ssafy.hellingers.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/profile")
//public class ProfileController {
//
//    @Autowired
//    private UserService userService;
//
//    // 마이페이지 데이터  (nickname, introduce, purpose, point, created_at,
//    // + 같은 메달을 설정한 3명의 랜덤 유저 nickname, 그 유저들이 갖고 있는 메달)
//
//    // 수정하기를 눌렀을 때의 데이터 (nickname, introduce, email)
//
//    // 삭제하기
//    @DeleteMapping("/delete/{email}")
//    public ResponseEntity<?> deleteProfile(@PathVariable String email) {
//        try {
//            userService.deleteUser(email);
//            return new ResponseEntity<>("DELETE_COMPLETE", HttpStatus.OK);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}