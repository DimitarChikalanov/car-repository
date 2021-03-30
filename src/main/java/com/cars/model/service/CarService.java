package com.cars.model.service;

import com.cars.model.domain.model.CarRequestModel;
import com.cars.model.domain.model.CarResponseModel;

public interface CarService {

    CarResponseModel createCar(CarRequestModel model);
}
