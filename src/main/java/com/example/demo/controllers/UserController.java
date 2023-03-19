package com.example.demo.controllers;

import com.example.demo.dtos.LoginRequest;
import com.example.demo.dtos.UserRequest;
import com.example.demo.dtos.UserResponse;
import com.example.demo.entities.User;
import com.example.demo.exceptions.MyException;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    ResponseEntity<User> save(@RequestBody UserRequest userRequest) throws MyException {
        User addedUser = userService.addUser(userRequest);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(addedUser);
    }

    @GetMapping
    ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allUsers);
    }

    @PostMapping(path = "/login")
    ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) throws MyException {
        try {
            UserResponse loggedUser = userService.login(loginRequest);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(loggedUser);
        } catch (MyException e) {
            UserResponse errorResponse = new UserResponse();
            errorResponse.setError(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
        }
    }

}

