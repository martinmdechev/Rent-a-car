package com.example.demo.controllers;

import com.example.demo.convertors.UserConvertor;
import com.example.demo.dtos.LoginRequest;
import com.example.demo.dtos.UserRequest;
import com.example.demo.dtos.UserResponse;
import com.example.demo.entities.User;
import com.example.demo.exceptions.MyException;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserConvertor userConvertor;

    @PostMapping
    ResponseEntity<User> save(@RequestBody UserRequest userRequest) throws MyException {
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.addUser(new User()));
    }

    @PostMapping(path = "/login")
    ResponseEntity<UserResponse> login(@RequestBody @Valid LoginRequest loginRequest)

}
