package com.example.garageApp.model

import jakarta.persistence.*

@Entity
data class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var model: String? = null,
    var brand: String? = null,
    @Column(name = "released_year")
    var year: Int = 0,
    var color: Color? = null
) {
    enum class Color {
        RED,
        BLUE,
        GREEN,
        YELLOW
    }
}