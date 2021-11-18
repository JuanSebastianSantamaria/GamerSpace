package com.project.GamerSpaceServer.services;

import java.util.Optional;

import com.project.GamerSpaceServer.model.Customer;

public interface ICustomerService {
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer findCustomerById(Long id);
    public Optional<Customer> findByUsername(String username);
}
