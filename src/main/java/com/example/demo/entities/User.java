package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(length = 255)
    private String firstName;
    @Column(length = 255)
    private String lastName;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String password;
    @Column(length = 255)
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations;

}
