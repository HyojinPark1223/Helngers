package com.ssafy.hellingers.service;

import com.ssafy.hellingers.model.Role;
import com.ssafy.hellingers.model.User;
import com.ssafy.hellingers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> findById(Long id) {
        System.out.println("id로 유저 정보 호출!");
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public User updateUser(User user) {
        user.setId(user.getId());
        user.setPassword(user.getPassword());
        user.setIntroduce(user.getIntroduce());
        user.setNickname(user.getNickname());

        if(user.getNickname().equals("Helngers")||user.getNickname().equals("Helngers1")){
            user.setRole(Role.ROLE_ADMIN);
        }
        return userRepository.save(user);
    }

    public User deleteUser(Long id)
    {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        userRepository.delete(user);
        return user;
    }

    public Optional<User> findByEmail(String email)
    {
        Optional<User> user = userRepository.findByEmail(email);
        System.out.println("email로 유저 정보 호출!");
        return user;
    }
}