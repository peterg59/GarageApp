package com.springboot.garageApp.repository;

import com.springboot.garageApp.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
