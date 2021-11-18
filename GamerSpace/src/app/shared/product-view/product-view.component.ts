import { Component, ElementRef, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { switchMap } from 'rxjs/operators';
import { Product } from 'src/app/model/product';
import { ProductPurchase } from 'src/app/model/product-purchase';
import { ProductsService } from 'src/app/services/products.service';
import { PurchasesService } from 'src/app/services/purchases.service';

@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  styleUrls: ['./product-view.component.css']
})
export class ProductViewComponent implements OnInit {
  product: Product = new Product(undefined!, undefined!, undefined!, undefined!, undefined!, undefined!);
  productToAdd: ProductPurchase = new ProductPurchase(undefined!, undefined!, undefined!, undefined!, undefined!, undefined!, undefined!, undefined!, undefined!);
  currentUserRol: string = '';
  quantity: number = 1;
  
  constructor(
    private route: ActivatedRoute,
    private productService: ProductsService,
    private purchaseService: PurchasesService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.findProduct();
    this.getCurrentUserRol();
  }

  findProduct(){
    this.route.paramMap
      .pipe(
        switchMap(params => this.productService.findById(+params.get('id')!)
      ))
      .subscribe(product => {
        this.product = product;
        this.productToAdd = new ProductPurchase(0, product.title, product.description, product.price, product.stock, product.photoPath, 0, 0, product.productId);
      });
  }

  getCurrentUserRol(){
    this.currentUserRol = localStorage.getItem('userLoggedRol')!;
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
        this.findProduct();
      });
  }

  open(content: any) {
    this.modalService.open(content);
    this.product.stock == 0? this.quantity = 0: this.quantity = 1;
  }
}
