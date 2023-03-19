package com.example.demo.dtos;

import com.example.demo.entities.Car;
import com.example.demo.entities.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class ReservationRequest {

    private User user;
    private Car car;
    private Instant pickupDate;
    private Instant returnDate;
}
