package com.cars.model.service;

import com.cars.model.domain.model.*;

import java.util.List;

public interface CarService {

    CarResponseModel createCar(CarRequestModel model);

    CarUpdateResponseModel updateCar(CarUpdateRequestModel model);

    List<CarResponseModel> getCarByOwner(String ownerName);

    List<String> getAllRegistrationNumber();

    List<String> getAllRegistrationNumberByBrand(String brandName);

    CarInfoResponseModel getAllInformationByRegistrationNumber(String registrationNumber);

    void deleteCar(CarDeleteRequestModel model);
}
