package com.example.demo.dtos;

import com.example.demo.entities.Car;
import com.example.demo.entities.User;
import lombok.*;

import java.time.Instant;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReservationResponse {

    private User user;
    private Car car;
    private Instant pickupDate;
    private Instant returnDate;
}
