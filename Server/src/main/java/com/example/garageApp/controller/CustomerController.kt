package com.example.garageApp.controller

import com.example.garageApp.model.Customer
import com.example.garageApp.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("/customers")
    fun getCustomers(): List<Customer> {
        return customerService.customers
    }

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Long): Customer? {
        return customerService.getCustomer(id)
    }

    @PostMapping("customers")
    fun addCustomer(@RequestBody customer: Customer?) {
        if (customer != null) {
            customerService.addCustomer(customer)
        }
    }

    @DeleteMapping("customer/{id}")
    fun deleteCustomer(@PathVariable id: Long) {
        customerService.deleteCustomer(id)
    }

    @PutMapping("customer/{id}")
    fun updateCustomer(@RequestBody customer: Customer?, @PathVariable id: Long) {
        if (customer != null) {
            customerService.updateCustomer(customer, id)
        }
    }
}
