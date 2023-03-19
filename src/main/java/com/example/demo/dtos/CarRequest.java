package com.example.demo.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarRequest {

    @Size(min = 2, message = "Car make must be at least 2 letters")
    private String make;
    @Size(min = 2, message = "Car model must be at least 2 letters")
    private String model;
    @Size(min = 8, message = "Car plate must be at least 8 letters")
    private String carPlate;
    @NotNull
    private String seats;
    @NotNull
    private BigDecimal pricePerDay;
}
