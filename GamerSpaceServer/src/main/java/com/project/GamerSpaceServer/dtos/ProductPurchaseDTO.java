package com.project.GamerSpaceServer.dtos;

public class ProductPurchaseDTO extends ProductDTO{
    
    private int quantity;
    private double total;
    private Long originalId;

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
    
    
}
