package com.project.GamerSpaceServer.services;

import com.project.GamerSpaceServer.model.Purchase;
import com.project.GamerSpaceServer.repositories.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SalesReportService implements ISalesReportService{
    @Autowired
    private PurchaseRepo purchaseRepo;
    @Autowired
    private IProductService productService;

    @Override
    public Page<Purchase> findAllPurchases(Pageable pageable) {
        return purchaseRepo.findAll(pageable);
    }

    @Override
    public Page<Purchase> findPurchasesByCustomer(String name, Pageable pageable) {
        return purchaseRepo.findByCustomerFullnameContains(name, pageable);
    }

    @Override
    public double getEarnings() {
        return purchaseRepo.getEarnings();
    }

    @Override
    public int getSoldProductsAmount() {
        return purchaseRepo.getSoldProductsAmount();
    }

    @Override
    public int getProductsInStock() {
        return productService.getProductsInStock();
    }

    @Override
    public int getTotalPurchases() {
        return (int)purchaseRepo.count();
    }
    
}
