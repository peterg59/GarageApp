package com.springboot.garageApp.repository;

import com.springboot.garageApp.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GarageRepository extends CrudRepository<Car, Long> {
    Car findById(long id);
    List<Car> findAll();
}
