package com.java.cars_tdd.module.car.service;

import com.java.cars_tdd.module.car.controller.dto.CreateCarDto;
import com.java.cars_tdd.module.car.entity.Car;
import com.java.cars_tdd.module.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Long createCar (CreateCarDto carDto) {
        Car entity = new Car(carDto.brand(), carDto.model());
        Car entitySaved = repository.save(entity);
        return entitySaved.getCarId();
    }
}
