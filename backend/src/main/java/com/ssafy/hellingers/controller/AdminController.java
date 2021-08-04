package com.ssafy.hellingers.controller;

import com.ssafy.hellingers.model.User;
import com.ssafy.hellingers.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/admin") //To reach here; api/admin/**
public class AdminController
{
    @Autowired
    private IUserService userService;

    //GET http://localhost:8080/api/admin/all
    // ADMIN 만 접근 가능
    @GetMapping("all")
    public ResponseEntity<?> getAllUsers()
    {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    //DELETE http://localhost:8080/api/admin/{userId}
    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId)
    {
        User user = userService.deleteUser(userId);
        return ResponseEntity.ok(user);
    }
}
