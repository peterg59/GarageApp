package com.example.garageApp.service

import com.example.garageApp.model.Customer
import com.example.garageApp.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class CustomerService(private val customerRepository: CustomerRepository) {
    val customers: List<Customer>
        get() {
            val customerList: MutableList<Customer> = ArrayList()
            customerRepository.findAll().forEach(
                Consumer { customer: Customer? ->
                    if (customer != null) {
                        customerList.add(customer)
                    }
               }
            )
            return customerList
        }

    fun getCustomer(id: Long): Customer? {
        return customerRepository.findById(id).orElse(Customer())
    }

    fun addCustomer(customer: Customer) {
        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Long) {
        customerRepository.deleteById(id)
    }

    fun updateCustomer(customer: Customer, id: Long) {
        val customerInDB = customerRepository.findById(id).get()
        if (customerInDB != null) {
            if (customer.lastName != null) customerInDB.lastName = customer.lastName
            if (customer.firstName != null) customerInDB.firstName = customer.firstName
            if (customer.mail != null) customerInDB.mail = customer.mail
            if (customer.address != null) customerInDB.address = customer.address
            if (customer.phoneNumber != 0) customerInDB.phoneNumber = customer.phoneNumber
            if (customer.age != 0) customerInDB.age = customer.age
            customerRepository.save(customerInDB)
        }
    }
}
