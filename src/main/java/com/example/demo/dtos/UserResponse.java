package com.example.demo.dtos;

import com.example.demo.entities.Reservation;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

}
