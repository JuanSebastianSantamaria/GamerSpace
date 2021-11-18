package com.project.GamerSpaceServer.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PurchaseCar {
    @Id
    @GeneratedValue
    Long purchaseCarId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchasesCar")
    private List<ProductPurchase> products;
    @OneToOne
    private Customer customer;

    public Long getPurchaseCarId() {
        return purchaseCarId;
    }

    public void setPurchaseCarId(Long purchaseCarId) {
        this.purchaseCarId = purchaseCarId;
    }

    public List<ProductPurchase> getProducts() {
        return products;
    }

    public void setProducts(List<ProductPurchase> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
