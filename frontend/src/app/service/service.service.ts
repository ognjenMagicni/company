import { Injectable,inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserReg } from '../model/user-reg.model';
import { User } from '../model/user.model';
import { Login } from '../model/login.model';
import { Package } from '../model/package.model';
import { LoginReturn } from '../model/login-return.model';
import { PackageDto } from '../model/package-dto.model';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  httpClient = inject(HttpClient);
  insertUser(user: UserReg): Observable<User>{
    let url = "http://localhost:8080/user/register"
    return this.httpClient.post<User>(url,user) 
  }
  loginUser(login: Login): Observable<LoginReturn>{
    let url = "http://localhost:8080/user/login";
    return this.httpClient.post<LoginReturn>(url,login);
  }
  getUser(user: string|null): Observable<User>{
    let url = "http://localhost:8080/user/"+user;
    return this.httpClient.get<User>(url);
  }
  getPackages(user:string|null,type:string|null): Observable<Package[]>{
    let url = "http://localhost:8080/user/package/"+type+"/"+user;
    return this.httpClient.get<Package[]>(url);
  }
  insertPackage(packageObj: Package): Observable<Package>{
    let url = "http://localhost:8080/user/package"
    console.log(packageObj)
    return this.httpClient.post<Package>(url,packageObj);
  }
  deletePackage(idUser:string|null, idPackage?:number): Observable<void>{
    let url = "http://localhost:8080/user/package/"+idUser+"/"+idPackage
    console.log(url)
    return this.httpClient.delete<void>(url)
  }
  ratePackage(packageDto: PackageDto): Observable<void>{
    let url="http://localhost:8080/user/update"
    return this.httpClient.put<void>(url,packageDto);
  }

  
}
