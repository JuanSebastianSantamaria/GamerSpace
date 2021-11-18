package com.project.GamerSpaceServer.repositories;

import com.project.GamerSpaceServer.model.ProductPurchase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductPurchaseRepo extends PagingAndSortingRepository<ProductPurchase, Long> {
    Page<ProductPurchase> findByPurchasesCarPurchaseCarId(Long id, Pageable pageable);
    Iterable<ProductPurchase> findByPurchasesCarPurchaseCarId(Long id);
    Page<ProductPurchase> findByPurchasePurchaseId(Long id, Pageable pageable);
}
