package com.cars.model.controller;

import com.cars.model.domain.model.CarRequestModel;
import com.cars.model.domain.model.CarResponseModel;
import com.cars.model.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/car")
    @ResponseStatus(HttpStatus.CREATED)
    CarResponseModel createNewCar(@RequestBody CarRequestModel model){
        return this.carService.createCar(model);
    }
}
