package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    private String make;
    private String model;
    private String carPlate;
    private String seats;
    private BigDecimal pricePerDay;
    @OneToMany(mappedBy = "car")
    private Set<Reservation> reservationSet;
}
