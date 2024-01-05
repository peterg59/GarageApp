package com.springboot.garageApp.controller

import com.springboot.garageApp.model.Customer
import com.springboot.garageApp.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
class CustomerController(private val customerService: CustomerService) {
    @get:RequestMapping("/customers")
    val customers: List<Customer>
        get() = customerService.customers

    @RequestMapping(method = [RequestMethod.GET], value = ["/customer/{id}"])
    fun getCustomer(@PathVariable id: Long): Customer {
        return customerService.getCustomer(id)
    }

    @RequestMapping(method = [RequestMethod.POST], value = ["customers"])
    fun addCustomer(@RequestBody customer: Customer?) {
        if (customer != null) {
            customerService.addCustomer(customer)
        }
    }

    @RequestMapping(method = [RequestMethod.DELETE], value = ["customer/{id}"])
    fun deleteCustomer(@PathVariable id: Long) {
        customerService.deleteCustomer(id)
    }

    @RequestMapping(method = [RequestMethod.PUT], value = ["customer/{id}"])
    fun updateCustomer(@RequestBody customer: Customer?, @PathVariable id: Long) {
        if (customer != null) {
            customerService.updateCustomer(customer, id)
        }
    }
}
