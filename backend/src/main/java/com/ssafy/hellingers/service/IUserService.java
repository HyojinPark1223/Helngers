package com.ssafy.hellingers.service;

import com.ssafy.hellingers.model.Role;
import com.ssafy.hellingers.model.User;

import java.util.List;


public interface IUserService
{
    User saveUser(User user);

    User changeRole(Role newRole, String username);

    User findByNickname(String nickname);

    User deleteUser(Long userId);

    List<User> findAllUsers();
}
