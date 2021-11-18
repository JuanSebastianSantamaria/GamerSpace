package com.project.GamerSpaceServer.dtos;

import java.util.List;

public class PurchaseCarDTO {
    Long purchaseCarId;

    private List<ProductPurchaseDTO> products;
    private CustomerDTO customer;
    
    public Long getPurchaseCarId() {
        return purchaseCarId;
    }
    public void setPurchaseCarId(Long purchaseCarId) {
        this.purchaseCarId = purchaseCarId;
    }
    public List<ProductPurchaseDTO> getProducts() {
        return products;
    }
    public void setProducts(List<ProductPurchaseDTO> products) {
        this.products = products;
    }
    public CustomerDTO getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    
}
