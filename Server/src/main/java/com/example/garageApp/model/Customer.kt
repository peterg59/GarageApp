package com.example.garageApp.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var lastName: String? = null
    var firstName: String? = null
    var mail: String? = null
    var phoneNumber: Int = 0
    var address: String? = null
    var age: Int = 0

    constructor()

    constructor(
        id: Long, lastName: String?, firstName: String?, mail: String?, phoneNumber: Int,
        address: String?, age: Int
    ) {
        this.id = id
        this.lastName = lastName
        this.firstName = firstName
        this.mail = mail
        this.phoneNumber = phoneNumber
        this.address = address
        this.age = age
    }
}
