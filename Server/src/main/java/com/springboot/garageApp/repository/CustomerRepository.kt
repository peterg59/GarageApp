package com.springboot.garageApp.repository

import com.springboot.garageApp.model.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer?, Long?>
