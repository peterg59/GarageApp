package com.springboot.garageApp.repository

import com.springboot.garageApp.model.Car
import org.springframework.data.repository.CrudRepository

interface GarageRepository : CrudRepository<Car?, Long?>
