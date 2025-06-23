package com.flutter.bucket.flutter_bucket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flutter.bucket.flutter_bucket.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhoneNumberAndPassword(String phoneNumber, String password);
}