package com.example.demo.services;

import com.example.demo.dtos.LoginRequest;
import com.example.demo.dtos.UserRequest;
import com.example.demo.entities.User;

public interface UserService {
    User addUser(User user);
    User findById(Long id) throws Throwable;
    void deleteById(Long id);
    User findByEmail(String email);
    void updatePassword(String password);
    UserRequest login(LoginRequest loginRequest);

}
