import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Product } from 'src/app/model/product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-products-list-admin',
  templateUrl: './products-list-admin.component.html',
  styleUrls: ['./products-list-admin.component.css']
})
export class ProductsListAdminComponent implements OnInit {
  products: Array<Product> = [];
  totalPages: Array<number> = [];
  size: number = 8;
  page: number = 0;

  constructor(
    private productService: ProductsService,
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

  deleteProduct(id: number){
    this.route.paramMap
      .pipe(switchMap(
        params => this.productService.deleteProduct(id, this.page, this.size)
        ))
      .subscribe(pageResponse => {
        this.totalPages = [];
        for (let i = 1; i <= Math.ceil(pageResponse.totalElements / this.size); i++) {
          this.totalPages.push(i);
        }
        this.products = pageResponse.content;
      })
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
