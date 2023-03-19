package com.example.demo.services.impl;

import com.example.demo.entities.Car;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.User;
import com.example.demo.exceptions.MyException;
import com.example.demo.repositories.ReservationRepository;
import com.example.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation makeReservation(Reservation reservation) {
        Reservation reservationToBeSaved = new Reservation();
        reservationToBeSaved.setCar(reservation.getCar());
        reservationToBeSaved.setUser(reservation.getUser());
        reservationToBeSaved.setPickupDate(reservation.getPickupDate());
        reservationToBeSaved.setReturnDate(reservation.getReturnDate());
        return (Reservation) reservationRepository.save(reservationToBeSaved);
    }

    @Override
    public Reservation findById(Long id) throws Throwable {

        return (Reservation) reservationRepository.findById(id)
                .orElseThrow(()-> new MyException("No such reservation found"));
    }

    @Override
    public Set<Reservation> findByUser(User user) {
        reservationRepository.findByUser(user.getId());

        return reservationRepository.findByUser(user.getId());
    }

    @Override
    public Set<Reservation> findByCar(Car car) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public List<Reservation> findByPeriod(Instant startDate, Instant endDate) {
        return reservationRepository.getReservations(startDate, endDate);
    }

    @Override
    public int reservationDuration(Instant pickUpDate, Instant returnDate) {
        return 0;
    }
}
