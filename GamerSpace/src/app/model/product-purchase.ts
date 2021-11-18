import { Product } from "./product";
import { Purchase } from "./purchase";
import { PurchasesCar } from "./purchases-car";

export class ProductPurchase extends Product{

    constructor(
        public productId: number,
        public title: string,
        public description: string,
        public price: number,
        public stock: number,
        public photoPath: string,
        public quantity: number,
        public total: number,
        public originalId: number
    ) {
        super(productId, title, description, price, stock, photoPath)
    }
}
