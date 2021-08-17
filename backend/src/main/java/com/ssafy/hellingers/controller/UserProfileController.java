package com.ssafy.hellingers.controller;

import com.ssafy.hellingers.dto.UserDto;
import com.ssafy.hellingers.model.User;
import com.ssafy.hellingers.repository.UserRepository;
import com.ssafy.hellingers.service.ProfileService;
import com.ssafy.hellingers.service.UserService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/profile")
public class UserProfileController {

//    private UserRepository userRepository;
//
//    @Autowired
//    public ProfileController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Autowired
    ProfileService profileService;

    // 마이페이지 데이터  (nickname, introduce, purpose, point, created_at,
    // + 같은 메달을 설정한 3명의 랜덤 유저 nickname, 그 유저들이 갖고 있는 메달)



    // 상세
    @GetMapping("/{id}")
    public User profileDetail(@PathVariable Long id){
//        try{
        System.out.println("123123123123123123123123");
            Optional<User> user = profileService.findById(id);
            return user.get();
//        }catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("DATA_LOAD_FAILED", HttpStatus.NO_CONTENT);
//        }
    }

    // 수정하기를 눌렀을 때의 데이터 (nickname, introduce, email) (GET)
    @GetMapping("/edit/{id}")
    public ResponseEntity<?> beforeEditProfile(@PathVariable Long id){
        try{
            Optional<User> user = profileService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("DATA_LOAD_FAILED", HttpStatus.NO_CONTENT);
        }
    }

    // 수정하기 (PUT)
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editProfile (@PathVariable Long id, @RequestBody @Valid UserDto user) {

        profileService.updateUser(id, user.convertToUser());

        String temp = user.getEmail();
        System.out.println(temp);
        Optional<User> modifiedUser =  profileService.findByEmail(temp);

        return new ResponseEntity<>(modifiedUser, HttpStatus.OK);
    }

    // 삭제하기
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long id) {
        try {
            profileService.deleteUser(id);
            return new ResponseEntity<>("DELETE_SUCCESS", HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("DELETE_FAILED", HttpStatus.NOT_FOUND);
        }

    }

}