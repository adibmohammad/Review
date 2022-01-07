package com.demo.insuranceproductsstore.reviewservice.repository;

import com.demo.insuranceproductsstore.reviewservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> getUserByUsernameAndAndUserStatusCode(String username, String statusCode);
    Optional<User> getUserByUsername(String username);
}
