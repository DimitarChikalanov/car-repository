package com.cars.model.controller;

import com.cars.model.domain.model.*;
import com.cars.model.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/car")
    @ResponseStatus(HttpStatus.CREATED)
    CarResponseModel createNewCar(@RequestBody CarRequestModel model) {
        return this.carService.createCar(model);
    }

    @PatchMapping("/car")
    CarUpdateResponseModel updateCar(@RequestBody CarUpdateRequestModel model) {
        return carService.updateCar(model);
    }

    @GetMapping("/car/owner/{name}")
    List<CarResponseModel> getAllCarByOwner(@PathVariable String name) {
        return this.carService.getCarByOwner(name);
    }

    @GetMapping("/car")
    List<String> getAllRegistrationNumber() {
        return this.carService.getAllRegistrationNumber();
    }

    @GetMapping("/car/brand/{brand}")
    List<String> getAllRegistrationNumberByBrand(@PathVariable String brand) {
        return this.carService.getAllRegistrationNumberByBrand(brand);
    }

    @GetMapping("/car/{registrationNumber}")
    CarInfoResponseModel getOwnerInformationByRegistrationNumber(@PathVariable String registrationNumber) {
        return this.carService.getAllInformationByRegistrationNumber(registrationNumber);
    }

    @DeleteMapping("/car")
    public void deleteCar(@RequestBody CarDeleteRequestModel model){
        this.carService.deleteCar(model);
    }
}
