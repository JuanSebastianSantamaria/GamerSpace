export class StatisticsDTO {
    constructor(
        public earnings: number,
        public soldProducts: number,
        public productsStock: number,
        public totalPurchases: number
    ) {}
}