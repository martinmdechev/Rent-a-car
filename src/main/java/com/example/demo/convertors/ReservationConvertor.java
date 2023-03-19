package com.example.demo.convertors;

import com.example.demo.entities.Car;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.User;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ReservationConvertor {

    public Reservation toReservation(User user, Car car, Instant pickUpDate, Instant returnDate){
    return Reservation.builder()
            .user(user)
            .car(car)
            .pickupDate(pickUpDate)
            .returnDate(returnDate)
            .build();
    }
}
