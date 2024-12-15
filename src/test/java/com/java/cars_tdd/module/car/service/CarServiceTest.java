package com.java.cars_tdd.module.car.service;

import com.java.cars_tdd.module.car.controller.dto.CreateCarDto;
import com.java.cars_tdd.module.car.entity.Car;
import com.java.cars_tdd.module.car.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CarServiceTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Captor
    private ArgumentCaptor<Car> carArgumentCaptor;

    @Captor
    private ArgumentCaptor<Long> longIdArgumentCaptor;

    @Test
    @DisplayName("Should create car with success")
    void createCar () {
        // Arrange
        Car mockCar = mock(Car.class);
        when(mockCar.getBrand()).thenReturn("Toyota");
        when(mockCar.getModel()).thenReturn("Corolla");

        doReturn(mockCar).when(carRepository).save(carArgumentCaptor.capture());

        CreateCarDto input = new CreateCarDto("Toyota","Corolla");

        // Act
        Long output = carService.createCar(input);

        // Assert
        assertNotNull(output);

        Car carCaptured = carArgumentCaptor.getValue();

        assertEquals(input.brand(), carCaptured.getBrand());
        assertEquals(input.model(), carCaptured.getModel());
    }
}
