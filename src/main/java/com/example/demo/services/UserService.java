package com.example.demo.services;

import com.example.demo.dtos.LoginRequest;
import com.example.demo.dtos.UserRequest;
import com.example.demo.dtos.UserResponse;
import com.example.demo.entities.User;

import java.util.List;

public interface UserService {
    User addUser(UserRequest addUserRequest);
    User findById(Long id) throws Throwable;
    void deleteById(Long id);
    User findByEmail(String email);
    void updatePassword(String password);
    UserResponse login(LoginRequest loginRequest);
    List<User> getAllUsers();

}
