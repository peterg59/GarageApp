package com.example.garageApp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

fun main(args: Array<String>) {
    SpringApplication.run(GarageAppApplication::class.java, *args)
}

@SpringBootApplication
open class GarageAppApplication
