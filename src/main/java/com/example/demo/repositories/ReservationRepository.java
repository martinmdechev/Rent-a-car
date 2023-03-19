package com.example.demo.repositories;

import com.example.demo.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository {
    Set<Reservation> findByUser(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM reservations WHERE pickUpDate BETWEEN ?1 AND ?2 OR returnDate BETWEEN ?1 AND ?2")
    List<Reservation> getReservations(Instant startDate, Instant endDate);

}
