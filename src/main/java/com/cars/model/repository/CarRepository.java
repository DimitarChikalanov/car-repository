package com.cars.model.repository;

import com.cars.model.domain.entity.Car;
import com.cars.model.domain.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    Car findByRegistrationNumber(String registrationNumber);

}
