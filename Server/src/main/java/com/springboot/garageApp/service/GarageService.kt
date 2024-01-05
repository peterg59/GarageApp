package com.springboot.garageApp.service

import com.springboot.garageApp.model.Car
import com.springboot.garageApp.repository.GarageRepository
import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class GarageService(private val garageRepository: GarageRepository) {
    val cars: List<Car>
        get() {
            val carList: MutableList<Car> = ArrayList()
            garageRepository.findAll().forEach(
                Consumer { car: Car? ->
                    if (car != null) {
                        carList.add(car)
                    }
                }
            )
            return carList
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
            if(car.brand != null) carInDB.brand = car.brand
            if(car.color != null) carInDB.color = car.color
            if(car.year != 0) carInDB.year = car.year
            if(car.model != null) carInDB.model = car.model
            garageRepository.save(carInDB)
        }
    }
}
