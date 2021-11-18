import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { switchMap } from 'rxjs/operators';
import { ProductPurchase } from 'src/app/model/product-purchase';
import { Purchase } from 'src/app/model/purchase';
import { PurchasesService } from 'src/app/services/purchases.service';

@Component({
  selector: 'app-purchase-car',
  templateUrl: './purchase-car.component.html',
  styleUrls: ['./purchase-car.component.css']
})
export class PurchaseCarComponent implements OnInit {
  products: Array<ProductPurchase> = [];
  purchase: Purchase = new Purchase(undefined!, undefined!, undefined!, undefined!, undefined!);
  totalPages: Array<number> = [];
  size: number = 8;
  page: number = 0;

  constructor(
    private purchaseService: PurchasesService,
    private modalService: NgbModal,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.page = 0;
    this.findProducts(this.page, this.size);
  }

  findProducts(page: number, size: number){
    this.route.paramMap
      .pipe(switchMap( 
        params => this.purchaseService.getAllProductsOnCar(page, size)
        ))
      .subscribe(pageResponse => {
        this.totalPages = [];
        for (let i = 1; i <= Math.ceil(pageResponse.totalElements / this.size); i++) {
          this.totalPages.push(i);
        }
        this.products = pageResponse.content;
      });
  }

  deleteFromCart(productId: number){
    this.route.paramMap
      .pipe(switchMap( 
        params => this.purchaseService.deleteProductFromCart(productId, this.page, this.size)
        ))
      .subscribe(pageResponse => {
        this.totalPages = [];
        for (let i = 1; i <= Math.ceil(pageResponse.totalElements / this.size); i++) {
          this.totalPages.push(i);
        }
        this.products = pageResponse.content;
      });
  }

  open(content: any) {
    this.modalService.open(content);
    this.calculatePurchase();
  }

  calculatePurchase(){
    let quantity = 0;
    let total = 0;
    this.products.forEach(p => {
      quantity += p.quantity;
      total += p.total;
    });
    this.purchase.quantity = quantity;
    this.purchase.total = total;
    this.payPurchase();
  }

  payPurchase(){
    this.route.paramMap
      .pipe(switchMap( 
        params => this.purchaseService.payPurchase(this.purchase)
        ))
      .subscribe(response => {
        this.findProducts(this.page, this.size);
      });
  }

  changePage(change: number, numberClicked: boolean){
    if(numberClicked){
      this.page = change - 1;
      this.findProducts(this.page, this.size);
    } else{
      if(this.page + change >= 0 && this.page + change < this.totalPages.length){
        this.page = this.page + change;
        this.findProducts(this.page, this.size);
      }
    }
  }

}
