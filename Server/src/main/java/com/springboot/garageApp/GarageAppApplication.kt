package com.springboot.garageApp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object GarageAppApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(GarageAppApplication::class.java, *args)
    }
}
