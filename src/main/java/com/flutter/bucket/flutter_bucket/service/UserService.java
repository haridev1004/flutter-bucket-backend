package com.flutter.bucket.flutter_bucket.service;

import com.flutter.bucket.flutter_bucket.dto.CreateUserRequest;
import com.flutter.bucket.flutter_bucket.dto.LoginRequest;
import com.flutter.bucket.flutter_bucket.dto.LoginResponse;
import com.flutter.bucket.flutter_bucket.dto.UserDto;
import com.flutter.bucket.flutter_bucket.exceptions.InvalidCredentialsException;
import com.flutter.bucket.flutter_bucket.model.User;
import com.flutter.bucket.flutter_bucket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(CreateUserRequest request) {
        User user = new User(
                null,
                request.getEmail(),
                request.getPhoneNumber(),
                request.getPassword(),
                request.getUsername());
        User savedUser = userRepository.save(user);
        return new UserDto(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getPhoneNumber(),
                savedUser.getUsername());
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getEmail(),
                        user.getPhoneNumber(),
                        user.getUsername()))
                .collect(Collectors.toList());
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByPhoneNumberAndPassword(
                request.getPhoneNumber(),
                request.getPassword());

        if (user == null) {
            throw new InvalidCredentialsException("Invalid phone number or password");
        }

        return new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getPhoneNumber());
    }
}
