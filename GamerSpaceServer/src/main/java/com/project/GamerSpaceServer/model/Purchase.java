package com.project.GamerSpaceServer.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Purchase {
    @Id
    @GeneratedValue
    Long purchaseId;

    private LocalDateTime date;
    private int quantity;
    private double total;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchase")
    private List<ProductPurchase> productsPurchased;
    @ManyToOne
    private Customer customer;
    
    public Long getPurchaseId() {
        return purchaseId;
    }
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }
    public String getDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = date.format(format);
        return formattedDate;
    }
    public void setDate(LocalDateTime date) {
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
    public List<ProductPurchase> getProductsPurchased() {
        return productsPurchased;
    }
    public void setProductsPurchased(List<ProductPurchase> productsPurchased) {
        this.productsPurchased = productsPurchased;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
