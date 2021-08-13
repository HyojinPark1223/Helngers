package com.ssafy.hellingers.service;

import com.ssafy.hellingers.model.Role;
import com.ssafy.hellingers.model.User;
import com.ssafy.hellingers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user)
    {
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setIntroduce(user.getIntroduce());
        user.setNickname(user.getNickname());
        user.setCreatedAt(LocalDateTime.now());
        //기본 설정은 is USER.
        user.setRole(Role.ROLE_USER);

        if(user.getNickname().equals("Helngers")||user.getNickname().equals("Helngers1")){
            user.setRole(Role.ROLE_ADMIN);
        }
        return userRepository.save(user);
    }


    @Override
    public Optional<User> login(String email, String password) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);
        if (user != null && user.get().getPassword().equals(password)) {
            return user;
        }else {
            throw new Exception("아이디나 비밀번호가 존재하지 않습니다.");
        }
    }



    @Override
    public User changeRole(Role newRole, String nickname)
    {
        User user = userRepository.findByNickname(nickname).orElseThrow(() -> new RuntimeException());
        user.setRole(newRole);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email)
    {
        Optional<User> user = userRepository.findByEmail(email);
        System.out.println("email로 유저 정보 호출!");
        return user;
    }

    @Override
    public Optional<User> findByNickname(String nickname) {
        Optional<User> user = userRepository.findByNickname(nickname);
        System.out.println("nickname으로 유저 정보 호출!");
        return user;
    }

    @Override
    public User deleteUser(Long id)
    {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        userRepository.delete(user);
        return user;
    }


    @Override
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }
}
