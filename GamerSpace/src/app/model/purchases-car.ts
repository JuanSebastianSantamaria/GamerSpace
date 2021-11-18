import { Customer } from "./customer";
import { ProductPurchase } from "./product-purchase";

export class PurchasesCar {
    public products: Array<ProductPurchase>;
    
    constructor(
        public purchaseCarId: number,
        public customer: Customer
    ) {
        this.products = [];
    }
}
