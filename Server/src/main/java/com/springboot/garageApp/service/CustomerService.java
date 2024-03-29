package com.springboot.garageApp.service;

import com.springboot.garageApp.model.Customer;
import com.springboot.garageApp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().forEach(customer ->
                customerList.add(customer)
        );
        return customerList;
    }

    public Customer getCustomer(long id){
        return customerRepository.findById(id).orElse(new Customer());
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteCustomer(long id){
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Customer customer, long id){
        Customer customerInDB = customerRepository.findById(id).get();
        if(customerInDB != null) {
            if(customer.getLastName() != null)
                customerInDB.setLastName(customer.getLastName());
            if(customer.getFirstName() != null)
                customerInDB.setFirstName(customer.getFirstName());
            if(customer.getMail() != null)
                customerInDB.setMail(customer.getMail());
            if(customer.getAddress() != null)
                customerInDB.setAddress(customer.getAddress());
            if(customer.getPhoneNumber() != 0)
                customerInDB.setPhoneNumber(customer.getPhoneNumber());
            if(customer.getAge() != 0)
                customerInDB.setAge(customer.getAge());
            customerRepository.save(customerInDB);
        }
    }
}
