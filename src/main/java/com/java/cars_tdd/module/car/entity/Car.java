package com.java.cars_tdd.module.car.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "brand", nullable = false)
    private String model;

    public Car () {}

    public Car(Long  carId, String model, String brand) {
        this.carId = carId;
        this.model = model;
        this.brand = brand;
    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Long getCarId() {
        return this.carId;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }


    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
