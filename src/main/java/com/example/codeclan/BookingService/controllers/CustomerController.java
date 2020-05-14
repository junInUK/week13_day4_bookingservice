package com.example.codeclan.BookingService.controllers;

import com.example.codeclan.BookingService.models.Customer;
import com.example.codeclan.BookingService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(

    ){
        System.out.println("test!!!");
        return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer,@PathVariable Long id){
        if(customer.getId().longValue() != id){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    //  response entity with no body
        }
        //  get the customer with the given id
        //  save the new customer body
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
