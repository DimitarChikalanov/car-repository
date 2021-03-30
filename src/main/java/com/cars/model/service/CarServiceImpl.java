package com.cars.model.service;

import com.cars.model.domain.entity.Brand;
import com.cars.model.domain.entity.Car;
import com.cars.model.domain.entity.Model;
import com.cars.model.domain.entity.Owner;
import com.cars.model.domain.model.CarRequestModel;
import com.cars.model.domain.model.CarResponseModel;
import com.cars.model.repository.BrandRepository;
import com.cars.model.repository.CarRepository;
import com.cars.model.repository.ModelRepository;
import com.cars.model.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final OwnerRepository ownerRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;


    public CarServiceImpl(CarRepository carRepository,
                          BrandRepository brandRepository,
                          OwnerRepository ownerRepository,
                          ModelRepository modelRepository,
                          ModelMapper modelMapper
    ) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.ownerRepository = ownerRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CarResponseModel createCar(CarRequestModel model) {
        Owner owner = this.ownerRepository.findByUsername(model.getUsername());
        Brand brand = this.brandRepository.findByName(model.getBrandName());
        Model brandModel = this.modelRepository.findByName(model.getModelName());
        Car car = new Car();
        car.setRegistrationNumber(model.getRegistrationNumber());
        car.setColor(model.getColor());
        car.setBrand(brand);
        car.setModel(brandModel);
        car.setOwner(owner);
        this.carRepository.saveAndFlush(car);
        return this.modelMapper.map(car, CarResponseModel.class);
    }
}
