import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Customer } from '../model/customer';
import { Rol } from '../model/rol';
import { User } from '../model/user';
import { AccountService } from '../services/account.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userLogin: User = new User(undefined!, undefined!, undefined!, undefined!, undefined!, undefined!, undefined!);
  newUser: Customer = new Customer(undefined!, undefined!, undefined!, undefined!, undefined!, undefined!, new Rol(1, 'customer'));
  invalid: boolean = false;
  loginFlag: boolean = false;
  message: string = '';

  constructor(
    private loginService: LoginService,
    private acountService: AccountService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.userLogin.username = "";
    this.userLogin.password = "";
    this.newUser.fullname = "";
    this.newUser.username = "";
    this.newUser.password = "";
    this.newUser.email = "";
    this.message = 'All fields are required.';
  }

  login(){
    this.loginFlag = true;
    this.validateFields();
    if(!this.invalid){
      this.loginService.login(this.userLogin.username, this.userLogin.password).subscribe( response => {
        sessionStorage.setItem('token', response.headers.get('Authorization')!);
        this.loginService.findUserByUsername(this.userLogin.username).subscribe( user => {
          this.loginService.setUserLoggedIn(user.userId, user.rol.rol);
          if(user.rol.rol == 'admin'){
            this.router.navigate(['/admin/products/']);
          } else {
            this.router.navigate(['/home']);
          }
        });
      }, error => {
        this.message = 'Incorrect username or password.';
        this.invalid = true;
      });
    }
  }

  register(){
    this.loginFlag = false;
    this.validateFields();
    if(!this.invalid){
      this.route.paramMap
      .pipe(
        switchMap(params => this.acountService.register(this.newUser)
      ))
      .subscribe(customer => {
        this.userLogin.username = this.newUser.username;
        this.userLogin.password = this.newUser.password;
        this.login();
      });
    }
  }

  validateFields(){
    if(this.loginFlag){
      if(this.userLogin.username == '' || this.userLogin.password == ''){
        this.message = 'All fields are required.';
        this.invalid = true;
      } else{
        this.invalid = false;
      }
    } else {
      if(this.newUser.fullname == '' || this.newUser.username == '' || this.newUser.password == '' || this.newUser.email == ""){
        this.message = 'All fields are required.';
        this.invalid = true;
      } else{
        this.invalid = false;
      }
    }
  }

  closeAlert(){
    this.invalid = false;
  }

}
