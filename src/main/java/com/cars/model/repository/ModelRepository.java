package com.cars.model.repository;

import com.cars.model.domain.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {

    Model findByName(String modelName);
}
