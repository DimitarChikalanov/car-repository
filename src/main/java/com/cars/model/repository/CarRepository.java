package com.cars.model.repository;

import com.cars.model.domain.entity.Brand;
import com.cars.model.domain.entity.Car;
import com.cars.model.domain.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    Car findByRegistrationNumber(String registrationNumber);

    List<Car> findAllByBrand(Brand brand);

    List<Car> findAllByOwner(Owner owner);

    @Query("SELECT c.registrationNumber FROM Car AS c")
    List<String> findAllRegistrationNumber();
}
