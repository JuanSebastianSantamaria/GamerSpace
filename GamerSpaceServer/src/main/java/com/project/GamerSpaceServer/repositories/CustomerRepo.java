package com.project.GamerSpaceServer.repositories;

import java.util.Optional;

import com.project.GamerSpaceServer.model.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
    Optional<Customer> findByUsername(String username);
}
