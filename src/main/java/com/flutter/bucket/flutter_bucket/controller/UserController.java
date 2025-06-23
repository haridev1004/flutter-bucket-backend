package com.flutter.bucket.flutter_bucket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.flutter.bucket.flutter_bucket.dto.CreateUserRequest;
import com.flutter.bucket.flutter_bucket.dto.LoginRequest;
import com.flutter.bucket.flutter_bucket.dto.LoginResponse;
import com.flutter.bucket.flutter_bucket.dto.UserDto;
import com.flutter.bucket.flutter_bucket.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public UserDto createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
