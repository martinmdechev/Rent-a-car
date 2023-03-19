package com.example.demo.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequest {
    @Size(min = 2, message = "Client first name should contain more than 2 characters")
    private String firstName;

    @Size(min = 2, message = "Client first name should contain more than 2 characters")
    private String lastName;

    @Size(min =2, message = "Email should have proper email format")
    private String email;

    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$", message = "" +
            "At least one upper case English letter\n" +
            "At least one lower case English letter\n" +
            "At least one digit\n" +
            "At least one special character\n" +
            "Minimum eight in length")
    private String password;

    @Size(min = 10, message = "Phone number must be at least 10 characters")
    private String phoneNumber;


}