package com.example.demo.services;

import com.example.demo.entities.Car;

public interface CarService {
    Car addCar(Car car);
    void deleteById(Long id);
    Car findById(Long id) throws Throwable;
}
