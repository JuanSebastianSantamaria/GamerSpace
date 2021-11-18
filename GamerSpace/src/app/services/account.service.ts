import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Customer } from '../model/customer';
import { Purchase } from '../model/purchase';
import { User } from '../model/user';
import { LoginService } from './login.service';
import { RestService } from './shared/rest.service';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(
    private restService: RestService
   ) { }

  register(customer: Customer) {
    const url = `${environment.globalURL}/customer/new`;
    return this.restService.post<Customer>(url, {
      userId: customer.userId,
      fullname: customer.fullname,
      username: customer.username,
      password: customer.password,
      email: customer.email,
      phoneNumber: customer.phoneNumber,
      rol: customer.rol
    });
  }

  updateProfile(user: User){
    const url = `${environment.globalURL}/${user.rol.rol}/update`;
    return this.restService.put<User>(url, {
      userId: user.userId,
      fullname: user.fullname,
      username: user.username,
      password: user.password,
      email: user.email,
      phoneNumber: user.phoneNumber,
      rol: user.rol
    });
  }

  findById(rol: string, id: number){
    const url = `${environment.globalURL}/${rol}/${id}`;
    return this.restService.get<User>(url);
  }

  setUserLoggedIn(id: number, rol: string) {
    LoginService.isUserLoggedIn = true;
    localStorage.setItem('userLoggedId',  "" + id);
    localStorage.setItem('userLoggedRol', rol);
  }
}
