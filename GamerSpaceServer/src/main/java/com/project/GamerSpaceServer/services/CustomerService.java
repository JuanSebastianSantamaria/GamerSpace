package com.project.GamerSpaceServer.services;

import java.util.Optional;

import com.project.GamerSpaceServer.model.Customer;
import com.project.GamerSpaceServer.repositories.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer editedCustomer = findCustomerById(customer.getUserId());
        editedCustomer.setFullname(customer.getFullname());
        editedCustomer.setEmail(customer.getEmail());
        editedCustomer.setPhoneNumber(customer.getPhoneNumber());
        return customerRepo.save(editedCustomer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public Optional<Customer> findByUsername(String username) {
        return customerRepo.findByUsername(username);
    }
    
}
