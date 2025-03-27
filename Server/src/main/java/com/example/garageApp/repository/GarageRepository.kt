package com.example.garageApp.repository

import com.example.garageApp.model.Car
import org.springframework.data.repository.CrudRepository

interface GarageRepository : CrudRepository<Car?, Long?>
