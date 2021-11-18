import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class RestService {
  constructor(private http: HttpClient) { }

  private handleError(error: HttpErrorResponse): Observable<any> {
    console.log(error);
    return throwError(error.error.message);
  }

  public get<T>(url:string): Observable<T> {
    return this.http
      .get<T>(url, {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          Accept: 'application/json'
        })/*,
        withCredentials: true*/
      })
      .pipe(
        catchError(this.handleError)
      );
  }

  public post<T>(url:string, data: T): Observable<T> {
    return this.http
      .post<T>(url, data, {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })/*,
        withCredentials: true*/
      })
      .pipe(
        catchError(this.handleError)
      );
  }

  public put<T>(url:string, data: T): Observable<T> {
    return this.http.put<T>(url, data/*, { withCredentials: true }*/).pipe(
      catchError(this.handleError)
    );
  }

  public delete<T>(url:string): Observable<T> {
    return this.http.delete<T>(url, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })/*,
      withCredentials: true*/
    })
      .pipe(
        catchError(this.handleError)
      );
  }

}
