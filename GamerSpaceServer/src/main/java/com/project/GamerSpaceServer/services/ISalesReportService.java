package com.project.GamerSpaceServer.services;

import com.project.GamerSpaceServer.model.Purchase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISalesReportService {
    public Page<Purchase> findAllPurchases(Pageable pageable);
    public Page<Purchase> findPurchasesByCustomer(String name, Pageable pageable);
    public double getEarnings();
    public int getSoldProductsAmount();
    public int getProductsInStock();
    public int getTotalPurchases();
}
