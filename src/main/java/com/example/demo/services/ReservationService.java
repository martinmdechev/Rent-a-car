package com.example.demo.services;

import com.example.demo.entities.Car;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.User;

import javax.management.Query;
import java.time.Instant;
import java.util.List;
import java.util.Set;

public interface ReservationService {
    Reservation makeReservation(Reservation reservation);
    Reservation findById(Long id) throws Throwable;
    Set<Reservation> findByUser(User user);
    Set<Reservation> findByCar(Car car);
    void deleteById(Long id);
    List<Reservation> findByPeriod(Instant startDate, Instant endDate);
    int reservationDuration(Instant pickUpDate, Instant returnDate);

}
