package com.example.demo.dtos;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private String firstName;

    private String lastName;
    private String error;
}
