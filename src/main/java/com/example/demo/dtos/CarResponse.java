package com.example.demo.dtos;

import lombok.*;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CarResponse {

    private String make;
    private String model;
    private String carPlate;
    private String seats;
    private BigDecimal pricePerDay;
}
