package com.springboot.garageApp.service

import com.springboot.garageApp.model.Car
import com.springboot.garageApp.repository.GarageRepository
import org.springframework.stereotype.Service

@Service
class GarageService(private val garageRepository: GarageRepository) {
    val cars: List<Car>
        get() {
            val cars: MutableList<Car> = ArrayList()
            garageRepository.findAll().forEach { car: Car? ->
                if (car != null) {
                    cars.add(car)
                }
            }
            return cars
        }

    fun getCar(id: Long): Car? {
        return garageRepository.findById(id).orElse(Car())
    }

    fun deleteCar(id: Long) {
        garageRepository.deleteById(id)
    }

    fun addCar(car: Car) {
        garageRepository.save(car)
    }

    fun updateCar(car: Car, id: Long) {
        val carInDB = garageRepository.findById(id).get()
        if (carInDB != null) {
            carInDB.brand = car.brand
            carInDB.color = car.color
            carInDB.year = car.year
            carInDB.model = car.model
            garageRepository.save(carInDB)
        }
    }

    companion object {
        val cars = ArrayList<Car>()
    }
}
