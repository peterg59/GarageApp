package com.springboot.garageApp.controller;

import com.springboot.garageApp.model.Car;
import com.springboot.garageApp.service.GarageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GarageController {

    private GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cars")
    public List<Car> getCars() {
        return garageService.getCars();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/car/{id}")
    public Car getCar(@PathVariable long id) {
        return garageService.getCar(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cars")
    public void addCar(@RequestBody Car car) {
        garageService.addCar(car);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/car/{id}")
    public void updateCar(@RequestBody Car car,@PathVariable long id) {
        garageService.updateCar(car, id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/car/{id}")
    public void deleteCar(@PathVariable long id) {
        garageService.deleteCar(id);
    }
}
