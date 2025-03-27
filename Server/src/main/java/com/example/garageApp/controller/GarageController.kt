package com.example.garageApp.controller

import com.example.garageApp.model.Car
import com.example.garageApp.service.GarageService
import org.springframework.web.bind.annotation.*

@RestController
class GarageController(private val garageService: GarageService) {

    @GetMapping("/cars")
    fun getCars(): List<Car> {
        return garageService.cars
    }

    @GetMapping("/car/{id}")
    fun getCar(@PathVariable id: Long): Car? {
        return garageService.getCar(id)
    }

    @PostMapping("/cars")
    fun addCar(@RequestBody car: Car?) {
        if(car != null){
            garageService.addCar(car)
        }
    }

    @PutMapping("/car/{id}")
    fun updateCar(@RequestBody car: Car?, @PathVariable id: Long) {
        if(car != null){
            garageService.updateCar(car, id)
        }
    }

    @DeleteMapping("/car/{id}")
    fun deleteCar(@PathVariable id: Long) {
        garageService.deleteCar(id)
    }
}
