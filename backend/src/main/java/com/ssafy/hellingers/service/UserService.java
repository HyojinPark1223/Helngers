package com.ssafy.hellingers.service;

import com.ssafy.hellingers.model.Role;
import com.ssafy.hellingers.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface UserService
{
    User saveUser(User user);

//    User updateUser(User user);

    Optional<User> login(String email, String password) throws Exception ;

    User changeRole(Role newRole, String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByNickname(String nickname);

//    Optional<User> findById(Long id);

    User deleteUser(Long id);

    List<User> findAllUsers();
}
