import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  url = 'http://localhost:8080/login/login';

  constructor(private http: HttpClient) { }


  getLogin(userInfo: any) : Observable<any> {
    return this.http.post(this.url, 
                          userInfo, 
                          {headers: {Accept: 'application/json'}}
            );
  }

  


}
