import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css']
})
export class NavigationBarComponent implements OnInit {
  isProductsActive: boolean = false;
  isProfileActive:boolean = false;
  isSalesActive:boolean = false;
  isHomeActive:boolean = false;
  isPurchasesActive:boolean = false;
  isCarActive:boolean = false;
  currentUserId:number = -2;
  currentUserRol:string = '';

  constructor(
    private router: Router,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    this.changeState();
    this.setCurrentUser();
  }

  changeState(){
    this.isProductsActive = this.router.url.startsWith('/admin/products');
    this.isProfileActive = this.router.url.startsWith('/profile');
    this.isSalesActive = this.router.url.startsWith('/admin/reports');
    this.isHomeActive = this.router.url.startsWith('/home');
    this.isPurchasesActive = this.router.url.startsWith('/purchases');
    this.isCarActive = this.router.url.startsWith('/car');
  }

  setCurrentUser(){
    this.currentUserId = +localStorage.getItem('userLoggedId')!;
    this.currentUserRol = localStorage.getItem('userLoggedRol')!;
  }

  logout(){
    this.loginService.logout().subscribe(response => {
      this.router.navigate(['/login']);
    });
  }

}
