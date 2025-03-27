package com.example.garageApp.model

import jakarta.persistence.*

@Entity
class Car {
    enum class Color {
        RED,
        BLUE,
        GREEN,
        YELLOW
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    @JvmField
    var model: String? = null
    @JvmField
    var brand: String? = null

    @JvmField
    @Column(name = "released_year")
    var year: Int = 0
    @JvmField
    var color: Color? = null

    constructor()

    constructor(id: Long, model: String?, brand: String?, year: Int, color: Color?) {
        this.id = id
        this.model = model
        this.brand = brand
        this.year = year
        this.color = color
    }
}