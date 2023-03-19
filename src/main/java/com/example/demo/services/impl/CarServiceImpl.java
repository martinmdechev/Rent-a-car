package com.example.demo.services.impl;

import com.example.demo.entities.Car;
import com.example.demo.exceptions.MyException;
import com.example.demo.repositories.CarRepository;
import com.example.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(Car car) {
        Car carToBeSaved = new Car();
        carToBeSaved.setCarPlate(car.getCarPlate());
        carToBeSaved.setMake(car.getMake());
        carToBeSaved.setModel(car.getModel());
        carToBeSaved.setSeats(car.getSeats());
        carToBeSaved.setPricePerDay(car.getPricePerDay());
    return (Car) carRepository.save(carToBeSaved);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);

    }

    @Override
    public Car findById(Long id) throws Throwable {
        return (Car) carRepository.findById(id)
                .orElseThrow(()-> new MyException("No such car found"));
    }
}
