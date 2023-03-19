package com.example.demo.convertors;

import com.example.demo.dtos.UserRequest;
import com.example.demo.dtos.UserResponse;
import com.example.demo.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UserConvertor {

    public User toUser(UserRequest userRequest){
    UUID uuid = UUID.randomUUID();
        return User.builder()
            .firstName(userRequest.getFirstName())
            .lastName((userRequest.getLastName()))
            .email(userRequest.getEmail())
            .phoneNumber(userRequest.getPhoneNumber())
            .build();
    }
    public UserResponse toResponse(User user){
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
