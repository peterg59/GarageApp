package com.springboot.garageApp.controller

import com.springboot.garageApp.model.Car
import com.springboot.garageApp.service.GarageService
import org.springframework.web.bind.annotation.*

@RestController
class GarageController(private val garageService: GarageService) {
    @get:RequestMapping("/cars")
    val cars: List<Car>
        get() = GarageService.cars

    @RequestMapping(method = [RequestMethod.GET], value = ["/car/{id}"])
    fun getCar(@PathVariable id: Long): Car? {
        return garageService.getCar(id)
    }

    @RequestMapping(method = [RequestMethod.POST], value = ["/cars"])
    fun addCar(@RequestBody car: Car?) {
        if(car != null){
            garageService.addCar(car)
        }
    }

    @RequestMapping(method = [RequestMethod.PUT], value = ["/car/{id}"])
    fun updateCar(@RequestBody car: Car?, @PathVariable id: Long) {
        if(car != null){
            garageService.updateCar(car, id)
        }
    }

    @RequestMapping(method = [RequestMethod.DELETE], value = ["/car/{id}"])
    fun deleteCar(@PathVariable id: Long) {
        garageService.deleteCar(id)
    }
}
