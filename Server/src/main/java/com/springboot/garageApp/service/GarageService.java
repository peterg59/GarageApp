package com.springboot.garageApp.service;

import com.springboot.garageApp.model.Car;
import com.springboot.garageApp.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {

    private GarageRepository garageRepository;

    public GarageService( GarageRepository garageRepository){
        this.garageRepository = garageRepository;
    }

    public List<Car> getCars() {
        return garageRepository.findAll();
    }

    public Car getCar(long id) {
        return garageRepository.findById(id);
    }

    public void deleteCar(long id) {
        garageRepository.deleteById(id);
    }

    public void addCar(Car car) {
        garageRepository.save(car);
    }

    public void updateCar(Car car, long id) {
        Car carInDB = garageRepository.findById(id);
        if(carInDB != null){
            if(car.getBrand() != null)
                carInDB.setBrand(car.getBrand());
            if(car.getColor() != null)
                carInDB.setColor(car.getColor());
            if(car.getYear() != 0)
                carInDB.setYear(car.getYear());
            if(car.getModel() != null)
                carInDB.setModel(car.getModel());
            garageRepository.save(carInDB);
        }
    }
}
