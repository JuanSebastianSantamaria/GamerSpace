package com.project.GamerSpaceServer.services;

import java.time.LocalDateTime;

import com.project.GamerSpaceServer.model.Product;
import com.project.GamerSpaceServer.model.ProductPurchase;
import com.project.GamerSpaceServer.model.Purchase;
import com.project.GamerSpaceServer.model.PurchaseCar;
import com.project.GamerSpaceServer.repositories.ProductPurchaseRepo;
import com.project.GamerSpaceServer.repositories.PurchaseCarRepo;
import com.project.GamerSpaceServer.repositories.PurchaseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService implements IPurchaseService{
    @Autowired
    private PurchaseCarRepo purchaseCarRepo;
    @Autowired
    private ProductPurchaseRepo productPurchaseRepo;
    @Autowired
    private IProductService productService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private PurchaseRepo purchaseRepo;

    @Override
    public PurchaseCar createPurchaseCar(PurchaseCar purchaseCar) {
        return purchaseCarRepo.save(purchaseCar);
    }

    public PurchaseCar findCarByCustomerId(Long customerId) {
        return purchaseCarRepo.findByCustomerUserId(customerId);
    }

    @Override
    public void addProductPurchaseToCar(ProductPurchase productPurchase, Long customerId) {
        PurchaseCar purchaseCar = findCarByCustomerId(customerId);
        Product product = productService.findProductById(productPurchase.getOriginalId());
        int stock = product.getStock() - productPurchase.getQuantity();
        if(stock >= 0 && productPurchase.getQuantity() > 0){
            product.setStock(stock);
            productService.updateProduct(product);
            productPurchase.setPurchaseCar(purchaseCar);
            productPurchaseRepo.save(productPurchase);
        }
    }

    @Override
    public Page<ProductPurchase> deleteProductPurchaseFromCar(Long productPurchaseId, Long customerId, Pageable pageable) {
        PurchaseCar purchaseCar = findCarByCustomerId(customerId);
        if(productPurchaseRepo.existsById(productPurchaseId)){
            ProductPurchase productPurchase = productPurchaseRepo.findById(productPurchaseId).get();
            Product product = productService.findProductById(productPurchase.getOriginalId());
            int stock = product.getStock() + productPurchase.getQuantity();
            product.setStock(stock);
            productService.updateProduct(product);
            productPurchaseRepo.deleteById(productPurchaseId);
        }
        return productPurchaseRepo.findByPurchasesCarPurchaseCarId(purchaseCar.getPurchaseCarId(), pageable);
    }

    @Override
    public Page<ProductPurchase> findAllProductsOnCar(Long customerId, Pageable pageable) {
        PurchaseCar purchaseCar = findCarByCustomerId(customerId);
        return productPurchaseRepo.findByPurchasesCarPurchaseCarId(purchaseCar.getPurchaseCarId(), pageable);
    }

    @Override
    public void createPurchase(Purchase purchase, Long customerId){
        purchase.setCustomer(customerService.findCustomerById(customerId));
        purchase.setDate(LocalDateTime.now());
        Purchase purchaseSaved = purchaseRepo.save(purchase);
        PurchaseCar purchaseCar = findCarByCustomerId(customerId);
        Iterable<ProductPurchase> products = productPurchaseRepo.findByPurchasesCarPurchaseCarId(purchaseCar.getPurchaseCarId());
        for (ProductPurchase p : products) {
            p.setPurchaseCar(null);
            p.setPurchase(purchaseSaved);
            productPurchaseRepo.save(p);
        }
    }

    @Override
    public Page<Purchase> findAllCustomerPurchases(Long customerId, Pageable pageable) {
        return purchaseRepo.findByCustomerUserId(customerId, pageable);
    }

    @Override
    public Page<ProductPurchase> findAllPurchaseDetails(Long purchaseId, Pageable pageable) {
        return productPurchaseRepo.findByPurchasePurchaseId(purchaseId, pageable);
    }
    
}
