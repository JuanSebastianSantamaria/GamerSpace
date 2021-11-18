import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { switchMap } from 'rxjs/operators';
import { ProductPurchase } from 'src/app/model/product-purchase';
import { Purchase } from 'src/app/model/purchase';
import { PurchasesService } from 'src/app/services/purchases.service';

@Component({
  selector: 'app-purchases-list',
  templateUrl: './purchases-list.component.html',
  styleUrls: ['./purchases-list.component.css']
})
export class PurchasesListComponent implements OnInit {
  purchases: Array<Purchase> = [];
  productsPurchased: Array<ProductPurchase> = [];
  modalPurchase: Purchase = new Purchase(undefined!, undefined!, undefined!, undefined!, undefined!);
  totalPages: Array<number> = [];
  size: number = 8;
  page: number = 0;
  totalPagesProducts: Array<number> = [];
  sizeProducts: number = 1;
  pageProducts: number = 0;

  constructor(
    private purchaseService: PurchasesService,
    private route: ActivatedRoute,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.page = 0;
    this.findPurchases(this.page, this.size);
  }

  findPurchases(page: number, size:number){
    this.route.paramMap
      .pipe(switchMap( 
        params => this.purchaseService.getCustomerPurchases(page, size)
        ))
      .subscribe(pageResponse => {
        this.totalPages = [];
        for (let i = 1; i <= Math.ceil(pageResponse.totalElements / this.size); i++) {
          this.totalPages.push(i);
        }
        this.purchases = pageResponse.content;
      });
  }

  findPurchaseDetails(purchaseId:number, page: number, size:number){
    this.route.paramMap
      .pipe(switchMap( 
        params => this.purchaseService.getPurchaseDetails(purchaseId, page, size)
        ))
      .subscribe(pageResponse => {
        this.totalPagesProducts = [];
        for (let i = 1; i <= Math.ceil(pageResponse.totalElements / this.sizeProducts); i++) {
          this.totalPagesProducts.push(i);
        }
        this.productsPurchased = pageResponse.content;
      });
  }

  open(content: any, purchaseId: number) {
    this.pageProducts = 0;
    this.modalService.open(content);
    this.modalPurchase = this.purchases.find(p => p.purchaseId == purchaseId)!;
    this.findPurchaseDetails(this.modalPurchase.purchaseId, this.pageProducts, this.sizeProducts);
  }

  changePage(change: number, numberClicked: boolean){
    if(numberClicked){
      this.page = change - 1;
      this.findPurchases(this.page, this.size);
    } else{
      if(this.page + change >= 0 && this.page + change < this.totalPages.length){
        this.page = this.page + change;
        this.findPurchases(this.page, this.size);
      }
    }
  }

  changePageModal(change: number, numberClicked: boolean){
    if(numberClicked){
      this.pageProducts = change - 1;
      this.findPurchaseDetails(this.modalPurchase.purchaseId, this.pageProducts, this.sizeProducts);
    } else{
      if(this.pageProducts + change >= 0 && this.pageProducts + change < this.totalPagesProducts.length){
        this.pageProducts = this.pageProducts + change;
        this.findPurchaseDetails(this.modalPurchase.purchaseId, this.pageProducts, this.sizeProducts);
      }
    }
  }

}
