import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Page } from '../model/page';
import { Product } from '../model/product';
import { RestService } from './shared/rest.service';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(
    private restService: RestService
  ) { }

  createProduct(product: Product){
    const url = `${environment.globalURL}/products/new`;
    return this.restService.post<Product>(url, {
      productId: product.productId,
      title: product.title,
      description: product.description,
      stock: product.stock,
      price: product.price,
      photoPath: product.photoPath
    });
  }

  updateProduct(product: Product){
    const url = `${environment.globalURL}/products/update`;
    return this.restService.put<Product>(url, {
      productId: product.productId,
      title: product.title,
      description: product.description,
      stock: product.stock,
      price: product.price,
      photoPath: product.photoPath
    });
  }

  deleteProduct(id: number, page: number, size:number){
    const url = `${environment.globalURL}/products/delete/${page}/${size}/${id}`;
    return this.restService.delete<Page>(url);
  }

  getAllProducts(page: number, size:number){
    const url = `${environment.globalURL}/products/list/${page}/${size}`;
    return this.restService.get<Page>(url);
  }

  findById(id: number){
    const url = `${environment.globalURL}/products/${id}`;
    return this.restService.get<Product>(url);
  }
}
