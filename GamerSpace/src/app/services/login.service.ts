import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../model/user';
import { RestService } from './shared/rest.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public static isUserLoggedIn: boolean;

  constructor(
    private http: HttpClient,
    private restService: RestService
  ) {
    LoginService.isUserLoggedIn = false;
   }

  login(username: string, password: string){
    const url = `${environment.globalURL}/login`;
    return this.http.post<any>(url, {
      username: username,
      password: password
    }, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      observe: 'response'
    })
    .pipe();
  }

  logout(){
    LoginService.isUserLoggedIn = false;
    localStorage.clear();
    sessionStorage.clear();
    const url = `${environment.globalURL}/logout`;
    return this.http.post(url, '', {
      withCredentials: true
    });
  }

  findUserByUsername(username: string){
    const url = `${environment.globalURL}/users/${username}`;
    return this.restService.get<User>(url);
  }

  setUserLoggedIn(id: number, rol: string) {
    LoginService.isUserLoggedIn = true;
    localStorage.setItem('userLoggedId',  "" + id);
    localStorage.setItem('userLoggedRol', rol);
  }
}
