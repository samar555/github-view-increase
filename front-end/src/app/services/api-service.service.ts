import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { UserDataI } from '../inerfaces/user-data-i';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {
 private apiView:string="http://localhost:8080/api/v1/user/views";
  constructor() { }
private http=inject(HttpClient)

  getIncreseViewApi(data:UserDataI){
  return this.http.post(this.apiView,data);

  }
}
