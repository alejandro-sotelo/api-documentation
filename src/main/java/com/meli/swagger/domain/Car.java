package com.meli.swagger.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Car {

    private int id;

    private String color;

    private String brand;

    private int year;

    private String model;
}
