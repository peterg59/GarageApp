package com.springboot.garageApp.service;

import com.springboot.garageApp.model.Car;
import com.springboot.garageApp.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GarageService {

    private GarageRepository garageRepository;

    private static ArrayList<Car> cars = new ArrayList<>();

    public GarageService( GarageRepository garageRepository){
        this.garageRepository = garageRepository;
    }

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        garageRepository.findAll().forEach(car -> {
            cars.add(car);
        });
        return cars;
    }

    public Car getCar(long id) {
        return garageRepository.findById(id).orElse(new Car());
    }

    public void deleteCar(long id) {
        garageRepository.deleteById(id);
    }

    public void addCar(Car car) {
        garageRepository.save(car);
    }

    public void updateCar(Car car, long id) {
        Car carInDB = garageRepository.findById(id).get();
        if(carInDB != null){
            carInDB.setBrand(car.getBrand());
            carInDB.setColor(car.getColor());
            carInDB.setYear(car.getYear());
            carInDB.setModel(car.getModel());
            garageRepository.save(carInDB);
        }
    }
}
