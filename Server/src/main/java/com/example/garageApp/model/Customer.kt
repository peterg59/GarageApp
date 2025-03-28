package com.example.garageApp.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var lastName: String? = null,
    var firstName: String? = null,
    var mail: String? = null,
    var phoneNumber: Int = 0,
    var address: String? = null,
    var age: Int = 0
)
