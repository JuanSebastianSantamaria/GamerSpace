import { Customer } from "./customer";
import { ProductPurchase } from "./product-purchase";

export class Purchase {
    
    public productsPurchased: Array<ProductPurchase>;
    
    constructor(
        public purchaseId: number,
        public date: string,
        public quantity: number,
        public total: number,
        public customer: Customer
    ) {
        this.productsPurchased = [];
    }
}
