package com.flutter.bucket.flutter_bucket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginRequest {
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String password;
}
