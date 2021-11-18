package com.project.GamerSpaceServer.repositories;

import com.project.GamerSpaceServer.model.PurchaseCar;

import org.springframework.data.repository.CrudRepository;

public interface PurchaseCarRepo extends CrudRepository<PurchaseCar, Long> {
    PurchaseCar findByCustomerUserId(Long id);
}
