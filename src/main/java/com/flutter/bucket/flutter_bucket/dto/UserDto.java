package com.flutter.bucket.flutter_bucket.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String phoneNumber;
    private String username;
}
