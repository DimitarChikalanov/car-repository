package com.cars.model.service;

import com.cars.model.domain.entity.Brand;
import com.cars.model.domain.entity.Car;
import com.cars.model.domain.entity.Model;
import com.cars.model.domain.entity.Owner;
import com.cars.model.domain.model.*;
import com.cars.model.repository.BrandRepository;
import com.cars.model.repository.CarRepository;
import com.cars.model.repository.ModelRepository;
import com.cars.model.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public CarUpdateResponseModel updateCar(CarUpdateRequestModel model) {
        Car car = this.carRepository.findByRegistrationNumber(model.getRegistrationNumber());

        if (!model.getOwnerName().equals("")){
            Owner owner = this.ownerRepository.findByUsername(model.getOwnerName());
            car.setOwner(owner);
        }

        if (!model.getColor().equals("")){
            car.setColor(car.getColor());
        }

        if (!model.getNewRegistrationNumber().equals("")){
            car.setRegistrationNumber(model.getNewRegistrationNumber());
        }

        this.carRepository.saveAndFlush(car);

        return this.modelMapper.map(car, CarUpdateResponseModel.class);
    }

    @Override
    public List<Car> getCarByOwner(String ownerName) {
        Owner owner = this.ownerRepository.findByUsername(ownerName);
         return this.carRepository.findAllByOwner(owner);
    }

    @Override
    public List<String> getAllRegistrationNumber() {
        return this.carRepository.findAllRegistrationNumber();
    }

    @Override
    public List<String> getAllRegistrationNumberByBrand(String brandName) {
        Brand brand = this.brandRepository.findByName(brandName);
        List<String> listRegistrationNumber = new ArrayList<>();

        for (Car car : this.carRepository.findAllByBrand(brand)) {
            listRegistrationNumber.add(car.getRegistrationNumber());
        }

        return listRegistrationNumber;
    }

    @Override
    public CarInfoResponseModel getAllInformationByRegistrationNumber(String registrationNumber) {
        Car car = this.carRepository.findByRegistrationNumber(registrationNumber);

        Owner owner = this.ownerRepository.findByUsername(car.getOwner().getUsername());

        Brand brand = this.brandRepository.findByName(car.getBrand().getName());

        Model model = this.modelRepository.findByName(car.getModel().getName());

        CarInfoResponseModel carInfoResponseModel = new CarInfoResponseModel();
        carInfoResponseModel.setUsername(owner.getUsername());
        carInfoResponseModel.setFirstName(owner.getFirstName());
        carInfoResponseModel.setLastname(owner.getLastname());
        carInfoResponseModel.setRegistrationNumber(car.getRegistrationNumber());
        carInfoResponseModel.setColor(car.getColor());
        carInfoResponseModel.setBrandName(brand.getName());
        carInfoResponseModel.setModel(model.getName());
        carInfoResponseModel.setHorsePower(model.getHorsePower());
        carInfoResponseModel.setVolume(model.getVolume());
        carInfoResponseModel.setEngineCapacity(model.getEngineCapacity());

        return carInfoResponseModel;
    }

    @Override
    public void deleteCar(CarDeleteRequestModel model) {
        Car car = this.carRepository.findByRegistrationNumber(model.getRegistrationNumber());

        this.carRepository.delete(car);
    }
}
