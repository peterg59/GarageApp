package com.example.garageApp.repository

import com.example.garageApp.model.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer?, Long?>
