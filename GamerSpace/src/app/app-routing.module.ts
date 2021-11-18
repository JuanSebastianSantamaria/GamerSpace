import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProductComponent } from './admin-view/create-product/create-product.component';
import { EditProductComponent } from './admin-view/edit-product/edit-product.component';
import { ProductsListAdminComponent } from './admin-view/products-list-admin/products-list-admin.component';
import { SalesReportComponent } from './admin-view/sales-report/sales-report.component';
import { AdminRolGuard } from './guards/admin-rol.guard';
import { AuthGuard } from './guards/auth.guard';
import { CustomerRolGuard } from './guards/customer-rol.guard';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginComponent } from './login/login.component';
import { ProductViewComponent } from './shared/product-view/product-view.component';
import { ProfileComponent } from './shared/profile/profile.component';
import { ProductsListComponent } from './user-view/products-list/products-list.component';
import { PurchaseCarComponent } from './user-view/purchase-car/purchase-car.component';
import { PurchasesListComponent } from './user-view/purchases-list/purchases-list.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'landing', component: LandingPageComponent },
  { path: 'admin/products', component: ProductsListAdminComponent, canActivate: [AuthGuard, AdminRolGuard] },
  { path: 'admin/products/new', component: CreateProductComponent, canActivate: [AuthGuard, AdminRolGuard] },
  { path: 'admin/reports', component: SalesReportComponent, canActivate: [AuthGuard, AdminRolGuard] },
  { path: 'admin/products/edit/:id', component: EditProductComponent, canActivate: [AuthGuard, AdminRolGuard] },
  { path: 'profile/:id', component: ProfileComponent, canActivate: [AuthGuard] },
  { path: 'home', component: ProductsListComponent, canActivate: [AuthGuard, CustomerRolGuard] },
  { path: 'products/view/:id', component: ProductViewComponent, canActivate: [AuthGuard] },
  { path: 'purchases', component: PurchasesListComponent, canActivate: [AuthGuard, CustomerRolGuard] },
  { path: 'car', component: PurchaseCarComponent, canActivate: [AuthGuard, CustomerRolGuard] },
  { path: '', pathMatch: 'full', redirectTo: 'landing' }
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
