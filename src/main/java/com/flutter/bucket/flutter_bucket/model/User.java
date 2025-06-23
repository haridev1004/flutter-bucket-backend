package com.flutter.bucket.flutter_bucket.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("email")

    private String email;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("password")

    private String password;
    @JsonProperty("username")
    private String username;
}
