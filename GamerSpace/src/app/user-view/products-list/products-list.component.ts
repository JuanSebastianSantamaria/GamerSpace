import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { switchMap } from 'rxjs/operators';
import { Product } from 'src/app/model/product';
import { ProductPurchase } from 'src/app/model/product-purchase';
import { ProductsService } from 'src/app/services/products.service';
import { PurchasesService } from 'src/app/services/purchases.service';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {
  products: Array<Product> = [];
  productToAdd: ProductPurchase = new ProductPurchase(undefined!, undefined!, undefined!, undefined!, undefined!, undefined!, undefined!, undefined!, undefined!);
  quantity: number = 0;
  totalPages: Array<number> = [];
  size: number = 8;
  page: number = 0;

  constructor(
    private productService: ProductsService,
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
        params => this.productService.getAllProducts(page, size)
        ))
      .subscribe(pageResponse => {
        this.totalPages = [];
        for (let i = 1; i <= Math.ceil(pageResponse.totalElements / this.size); i++) {
          this.totalPages.push(i);
        }
        this.products = pageResponse.content;
      });
  }

  addToCart(){
    this.productToAdd.quantity = this.quantity;
    this.productToAdd.total = this.quantity * this.productToAdd.price;
    this.route.paramMap
      .pipe(switchMap( 
        params => this.purchaseService.addProductToCart(this.productToAdd)
        ))
      .subscribe(response => {
        this.modalService.dismissAll();
        this.findProducts(this.page, this.size);
      });
  }

  open(content: any, id: number) {
    this.modalService.open(content);
    const p = this.products.find(p => id == p.productId)!;
    this.productToAdd = new ProductPurchase(0, p.title, p.description, p.price, p.stock, p.photoPath, 0, 0, p.productId);
    this.productToAdd.stock == 0? this.quantity = 0: this.quantity = 1;
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
