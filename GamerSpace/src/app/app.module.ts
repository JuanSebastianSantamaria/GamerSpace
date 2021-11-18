import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NavigationBarComponent } from './shared/navigation-bar/navigation-bar.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { ProductsListAdminComponent } from './admin-view/products-list-admin/products-list-admin.component';
import { CreateProductComponent } from './admin-view/create-product/create-product.component';
import { EditProductComponent } from './admin-view/edit-product/edit-product.component';
import { SalesReportComponent } from './admin-view/sales-report/sales-report.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ProfileComponent } from './shared/profile/profile.component';
import { ProductsListComponent } from './user-view/products-list/products-list.component';
import { PurchasesListComponent } from './user-view/purchases-list/purchases-list.component';
import { ProductViewComponent } from './shared/product-view/product-view.component';
import { TokenInterceptorService } from './interceptors/token-interceptor.service';
import { PurchaseCarComponent } from './user-view/purchase-car/purchase-car.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationBarComponent,
    LandingPageComponent,
    LoginComponent,
    ProductsListAdminComponent,
    CreateProductComponent,
    EditProductComponent,
    SalesReportComponent,
    ProfileComponent,
    ProductsListComponent,
    PurchasesListComponent,
    ProductViewComponent,
    PurchaseCarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
