package com.ssafy.hellingers.service;

import com.ssafy.hellingers.model.Role;
import com.ssafy.hellingers.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface UserService
{
    User saveUser(User user);

    Optional<User> login(String email, String password) throws Exception ;

    User changeRole(Role newRole, String username);

    User findByEmail(String email);

    User findByNickname(String nickname);

    User deleteUser(String email);

    List<User> findAllUsers();
}
