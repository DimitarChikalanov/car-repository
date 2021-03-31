package com.cars.model.service;

import com.cars.model.domain.model.CarRequestModel;
import com.cars.model.domain.model.CarResponseModel;
import com.cars.model.domain.model.CarUpdateRequestModel;
import com.cars.model.domain.model.CarUpdateResponseModel;

public interface CarService {

    CarResponseModel createCar(CarRequestModel model);

    CarUpdateResponseModel updateCar(CarUpdateRequestModel model);
}
