export class Product {
    constructor(
        public productId: number,
        public title: string,
        public description: string,
        public price: number,
        public stock: number,
        public photoPath: string
    ) {}
}
