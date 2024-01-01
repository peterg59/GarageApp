package com.springboot.garageApp.controller;

import com.springboot.garageApp.model.Customer;
import com.springboot.garageApp.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer/{id}")
    public Customer getCustomer(@PathVariable long id){
        return customerService.getCustomer(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "customers")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "customer/{id}")
    public void deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "customer/{id}")
    public void updateCustomer(@RequestBody Customer customer,@PathVariable long id){
        customerService.updateCustomer(customer, id);
    }
}
