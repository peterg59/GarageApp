package com.example.garageApp.model

import jakarta.persistence.*

@Entity
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "last_name")
    var lastName: String? = null,
    @Column(name = "first_name")
    var firstName: String? = null,
    var mail: String? = null,
    @Column(name = "phone_number")
    var phoneNumber: Int = 0,
    var address: String? = null,
    var age: Int = 0
)
