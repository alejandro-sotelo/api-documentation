package com.meli.swagger.controller;

import com.meli.swagger.domain.Car;
import com.meli.swagger.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private CarService carService;

    CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/{id}")
    Car findById(@PathVariable("id") int id) throws InterruptedException {
        final Car car = carService.getById(id);
        return car;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Car create(@RequestBody Car car) {
        return carService.create(car);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") int id, @RequestBody Car car) {
        car.setId(id);
        carService.update(car);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        carService.deleteById(id);
    }
}