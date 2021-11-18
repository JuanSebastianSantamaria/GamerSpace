import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Page } from '../model/page';
import { ProductPurchase } from '../model/product-purchase';
import { Purchase } from '../model/purchase';
import { RestService } from './shared/rest.service';

@Injectable({
  providedIn: 'root'
})
export class PurchasesService {

  constructor(
    private restService: RestService
  ) { }

  addProductToCart(product: ProductPurchase) {
    const id = localStorage.getItem('userLoggedId');
    const url = `${environment.globalURL}/purchases/cart/${id}/add`;
    return this.restService.post<any>(url, {
      productId: product.productId,
      title: product.title,
      description: product.description,
      stock: product.stock,
      price: product.price,
      photoPath: product.photoPath,
      quantity: product.quantity,
      total: product.total,
      originalId: product.originalId
    });
  }

  deleteProductFromCart(productId: number, page: number, size:number){
    const id = localStorage.getItem('userLoggedId');
    const url = `${environment.globalURL}/purchases/cart/${id}/delete/${productId}/${page}/${size}`;
    return this.restService.delete<Page>(url);
  }

  getCustomerPurchases(page: number, size:number) {
    const id = localStorage.getItem('userLoggedId');
    const url = `${environment.globalURL}/purchases/list/${id}/${page}/${size}`;
    return this.restService.get<Page>(url);
  }

  getAllProductsOnCar(page: number, size:number){
    const id = localStorage.getItem('userLoggedId');
    const url = `${environment.globalURL}/purchases/cart/${id}/${page}/${size}`;
    return this.restService.get<Page>(url);
  }

  payPurchase(purchase: Purchase){
    const id = localStorage.getItem('userLoggedId');
    const url = `${environment.globalURL}/purchases/pay/${id}`;
    return this.restService.post<any>(url, {
      productId: purchase.purchaseId,
      date: purchase.date,
      quantity: purchase.quantity,
      total: purchase.total
    });
  }

  getPurchaseDetails(purchaseID: number, page: number, size:number){
    const url = `${environment.globalURL}/purchases/list/details/${purchaseID}/${page}/${size}`;
    return this.restService.get<Page>(url);
  }
}
