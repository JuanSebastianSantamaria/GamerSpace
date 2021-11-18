import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Product } from 'src/app/model/product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
  invalid: boolean = false;
  product: Product = new Product(undefined!, undefined!, undefined!, undefined!, undefined!, undefined!);

  constructor(
    private productService: ProductsService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.product.title = "";
    this.product.description = "";
    this.product.photoPath = "";
  }

  createProduct(){
    this.validateFields();
    if(!this.invalid){
      this.route.paramMap
      .pipe(
        switchMap(params => this.productService.createProduct(this.product)
      ))
      .subscribe(product => {
        this.router.navigate(['/admin/products/']);
      });
    }
  }

  validateFields(){
    if(this.product.title == '' || this.product.description == '' || this.product.photoPath == '' || this.product.price == undefined || this.product.stock == undefined){
        this.invalid = true;
      } else{
        this.invalid = false;
      }
  }

}
