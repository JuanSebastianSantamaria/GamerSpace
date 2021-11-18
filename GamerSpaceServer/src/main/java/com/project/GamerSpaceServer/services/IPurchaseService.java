package com.project.GamerSpaceServer.services;

import com.project.GamerSpaceServer.model.ProductPurchase;
import com.project.GamerSpaceServer.model.Purchase;
import com.project.GamerSpaceServer.model.PurchaseCar;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPurchaseService {
    public PurchaseCar createPurchaseCar(PurchaseCar purchaseCar);
    public void addProductPurchaseToCar(ProductPurchase productPurchase, Long customerId);
    public Page<ProductPurchase> deleteProductPurchaseFromCar(Long productPurchaseId, Long customerId, Pageable pageable);
    public Page<ProductPurchase> findAllProductsOnCar(Long customerId, Pageable pageable);
    public void createPurchase(Purchase purchase, Long customerId);
    public Page<Purchase> findAllCustomerPurchases(Long customerId, Pageable pageable);
    public Page<ProductPurchase> findAllPurchaseDetails(Long purchaseId, Pageable pageable);
}
