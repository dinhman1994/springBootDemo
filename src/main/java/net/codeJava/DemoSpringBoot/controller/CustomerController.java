/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.controller;

import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codeJava.DemoSpringBoot.model.Customer;
import net.codeJava.DemoSpringBoot.repository.CustomerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Duong Dinh Binh
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    //get all customers
    @GetMapping("customers")
    public List<Customer> getCustomers(){
        return this.customerRepository.findAll();
    }
    
    //add a customers
    @PostMapping("customers")
    public Customer addCustomer(@RequestBody Object requestBody){
        LinkedHashMap<String,String> bodyParser = (LinkedHashMap<String,String>) requestBody;
        int age = Integer.parseInt(bodyParser.get("age"));
        String name = bodyParser.get("name");
        int phone = Integer.parseInt(bodyParser.get("phone"));
        List<Customer> customers = customerRepository.findCustomerByPhone(phone);
        if (customers.size()>0){
            return customers.get(0);
        }
        return customerRepository.save(new Customer(name, age, phone));
    }
}
