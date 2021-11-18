package com.project.GamerSpaceServer.repositories;

import com.project.GamerSpaceServer.model.Purchase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PurchaseRepo extends PagingAndSortingRepository<Purchase, Long> {
    @Query("SELECT SUM(p.total) FROM Purchase p")
    double getEarnings();

    @Query("SELECT SUM(p.quantity) FROM Purchase p")
    int getSoldProductsAmount();

    Page<Purchase> findByCustomerUserId(Long customerId, Pageable pageable);

    Page<Purchase> findByCustomerFullnameContains(String name, Pageable pageable);
}
