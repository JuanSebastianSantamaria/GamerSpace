package com.project.GamerSpaceServer.dtos;

public class StatisticsDTO {
    private double earnings;
    private int soldProducts;
    private int productsStock;
    private int totalPurchases;

    public double getEarnings() {
        return earnings;
    }
    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }
    public int getSoldProducts() {
        return soldProducts;
    }
    public void setSoldProducts(int soldProducts) {
        this.soldProducts = soldProducts;
    }
    public int getProductsStock() {
        return productsStock;
    }
    public void setProductsStock(int productsStock) {
        this.productsStock = productsStock;
    }
    public int getTotalPurchases() {
        return totalPurchases;
    }
    public void setTotalPurchases(int totalPurchases) {
        this.totalPurchases = totalPurchases;
    }
    
}
