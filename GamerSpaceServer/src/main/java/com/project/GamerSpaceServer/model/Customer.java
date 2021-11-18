package com.project.GamerSpaceServer.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer extends UserGS{

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Purchase> purchases;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    private PurchaseCar purchasesCar;

    public List<Purchase> getPurchases() {
        return purchases;
    }
    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
    public PurchaseCar getPurchasesCar() {
        return purchasesCar;
    }
    public void setPurchasesCar(PurchaseCar purchasesCar) {
        this.purchasesCar = purchasesCar;
    }

}
