package com.project.GamerSpaceServer.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ProductPurchase extends IProduct{

    private int quantity;
    private double total;
    private Long originalId;
    @ManyToOne
    private PurchaseCar purchasesCar;
    @ManyToOne
    private Purchase purchase;
    
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public Long getOriginalId() {
        return originalId;
    }
    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
    }
    public PurchaseCar getPurchaseCar() {
        return purchasesCar;
    }
    public void setPurchaseCar(PurchaseCar purchasesCar) {
        this.purchasesCar = purchasesCar;
    }
    public Purchase getPurchase() {
        return purchase;
    }
    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
    
}
