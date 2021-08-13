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

    public User updateUser(Long id, User user) {

        User targetUser = userRepository.findById(id).get();
        targetUser.setPassword(user.getPassword());
        targetUser.setIntroduce(user.getIntroduce());
        targetUser.setNickname(user.getNickname());


        return userRepository.save(targetUser);
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