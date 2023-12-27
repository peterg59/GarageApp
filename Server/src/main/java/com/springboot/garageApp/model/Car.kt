package com.springboot.garageApp.model

import jakarta.persistence.*

@Entity
class Car(
    @field:GeneratedValue(strategy = GenerationType.AUTO)
    @field:Id
    var id: Long,
    var model: String,
    var brand: String,
    @field:Column(name = "released_year")
    var year: Int,
    var color: Color
) {
    enum class Color {
        RED,
        BLUE,
        GREEN,
        YELLOW
    }
}
