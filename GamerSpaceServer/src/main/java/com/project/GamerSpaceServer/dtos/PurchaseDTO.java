package com.project.GamerSpaceServer.dtos;

import java.util.List;

public class PurchaseDTO {
    Long purchaseId;
    private String date;
    private int quantity;
    private double total;
    private List<ProductPurchaseDTO> productsPurchased;
    private CustomerDTO customer;

    public Long getPurchaseId() {
        return purchaseId;
    }
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
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
    public List<ProductPurchaseDTO> getProductsPurchased() {
        return productsPurchased;
    }
    public void setProductsPurchased(List<ProductPurchaseDTO> productsPurchased) {
        this.productsPurchased = productsPurchased;
    }
    public CustomerDTO getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    
}
