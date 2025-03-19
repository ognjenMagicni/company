import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Manager } from '../model/manager.model';
import { Observable } from 'rxjs';
import { Driver } from '../model/driver.model';
import { Vehicle } from '../model/vehicle.model';
import { UserReg } from '../model/user-reg.model';
import { DriverVehicle } from '../model/driver-vehicle-model';
@Injectable({
  providedIn: 'root'
})
export class ManagerServiceService {
  httpClient = inject(HttpClient);

  getManager(username: string|null): Observable<Manager>{
    let url = "http://localhost:8080/manager/"+username;
    return this.httpClient.get<Manager>(url);
  }
  getDrivers(): Observable<Driver[]>{
    let url = "http://localhost:8080/manager/driver";
    return this.httpClient.get<Driver[]>(url);
  }
  getDriversWithoutVehicle(): Observable<Driver[]>{
    let url = "http://localhost:8080/manager/drivers_fkvehicle_null";
    return this.httpClient.get<Driver[]>(url);
  }
  getVehicle(username?: string|null): Observable<Vehicle>{
    let url = "http://localhost:8080/manager/vehicle/"+username
    return this.httpClient.get<Vehicle>(url);
  }
  getVehicles(): Observable<Vehicle[]>{
    let url = "http://localhost:8080/manager/vehicle";
    return this.httpClient.get<Vehicle[]>(url);
  }
  getVehiclesSmall(): Observable<Vehicle[]>{
    let url = "http://localhost:8080/manager/small_service";
    return this.httpClient.get<Vehicle[]>(url);
  }
  getVehiclesBig(): Observable<Vehicle[]>{
    let url = "http://localhost:8080/manager/big_service";
    return this.httpClient.get<Vehicle[]>(url);
  }
  getVehiclesKm(): Observable<Vehicle[]>{
    let url = "http://localhost:8080/manager/km";
    return this.httpClient.get<Vehicle[]>(url);
  }
  getVehiclesYear(): Observable<Vehicle[]>{
    let url = "http://localhost:8080/manager/year";
    return this.httpClient.get<Vehicle[]>(url);
  }
  getVehiclesUnused(): Observable<Vehicle[]>{
    let url = "http://localhost:8080/manager/unused_vehicles";
    return this.httpClient.get<Vehicle[]>(url);
  }
  addVehicle(vehicle: Vehicle): Observable<Vehicle>{
    let url = "http://localhost:8080/manager/insert_vehicle";
    return this.httpClient.post<Vehicle>(url,vehicle);
  }
  deleteVehicle(idVehicle?: string|null): Observable<void>{
    let url = "http://localhost:8080/manager/delete_vehicle/"+idVehicle;
    return this.httpClient.delete<void>(url);
  }
  addDriver(userReg?: UserReg|null):Observable<Driver>{
    let url = "http://localhost:8080/manager/insert_driver";
    return this.httpClient.post<Driver>(url,userReg);
  }
  editDriver(driver?: Driver|null):Observable<Driver>{
    let url = "http://localhost:8080/manager/edit_driver";
    return this.httpClient.post<Driver>(url,driver);
  }
  deleteDriver(username?: string|null){
    let url = "http://localhost:8080/manager/delete_driver/"+username;
    return this.httpClient.delete<void>(url)
  }
  addDriverVehicle(driverVehicle: DriverVehicle): Observable<void>{
    let url = "http://localhost:8080/manager/driver_vehicle"
    return this.httpClient.post<void>(url,driverVehicle)
  }
  removeDriverVehicle(driverVehicle: DriverVehicle): Observable<void>{
    let url = "http://localhost:8080/manager/driver_vehicle"
    return this.httpClient.delete<void>(url,{body:driverVehicle})
  }
  

}
