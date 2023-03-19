package com.example.demo.convertors;

import com.example.demo.dtos.CarRequest;
import com.example.demo.dtos.CarResponse;
import com.example.demo.entities.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CarConvertor {

    public Car toCar(CarRequest carRequest){
        UUID uuid = UUID.randomUUID();
        return Car.builder()
                .make(carRequest.getMake())
                .model(carRequest.getModel())
                .carPlate(carRequest.getCarPlate())
                .seats(carRequest.getSeats())
                .pricePerDay(carRequest.getPricePerDay())
                .build();
    }
    public CarResponse toResponse(Car car){
        return CarResponse.builder()
                .make(car.getMake())
                .model(car.getModel())
                .carPlate(car.getCarPlate())
                .seats(car.getSeats())
                .pricePerDay(car.getPricePerDay())
                .build();
    }
}
