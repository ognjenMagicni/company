import { Injectable,inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Driver } from '../model/driver.model';
import { Package } from '../model/package.model';
@Injectable({
  providedIn: 'root'
})
export class DriverServiceService {
  httpClient = inject(HttpClient);

  getDriver(username?: string|null): Observable<Driver>{
    let url = "http://localhost:8080/driver/"+username;
    return this.httpClient.get<Driver>(url)
  }
  getAllWaitingPackages(username?: string | null, type?: string|null): Observable<Package[]>{
    if(type=="waiting"){
      let url = "http://localhost:8080/driver/waitingpackages"
      return this.httpClient.get<Package[]>(url)
    }
    else{
      let url = "http://localhost:8080/driver/package/" + type + "/" + username;
      console.log(url)
      return this.httpClient.get<Package[]>(url)
    }
  }
  waiting2accepted(username:string|null, idPackage?:number): Observable<void>{
    let url = "http://localhost:8080/driver/waiting2accepted/"+username+"/"+idPackage;
    return this.httpClient.put<void>(url,{});
  }
  accepted2delivered(username:string|null, idPackage?:number): Observable<void>{
    let url = "http://localhost:8080/driver/accepted2delivered/"+username+"/"+idPackage;
    return this.httpClient.put<void>(url,{});
  }

}
