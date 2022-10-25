package com.meli.swagger.service;

import com.meli.swagger.domain.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarService {

    public Car getById(int id) {
        return Car.builder().id(id).brand("Honda").color("black").model("Civic").year(2020).build();
    }

    public Car create(Car car) {
        log.info("Car created: " + car.toString());
        return Car.builder().id(car.getId()).brand(car.getBrand())
                  .color(car.getColor()).model(car.getModel()).year(car.getYear()).build();
    }

    public void update(Car car) {
        log.info("Car updated: " + car.toString());
    }

    public void deleteById(int id) {
        log.info(String.format("Car with id %d deleted: ", id));
    }
}