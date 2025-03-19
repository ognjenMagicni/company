import { CommonModule, NgIf } from '@angular/common';
import { Component, inject, Input, OnInit } from '@angular/core';
import { ManagerServiceService } from '../../service/manager-service.service';
import { Driver } from '../../model/driver.model';
import { DriverVehicle } from '../../model/driver-vehicle-model';

@Component({
  selector: 'app-driver-vehicle',
  imports: [NgIf,CommonModule],
  templateUrl: './driver-vehicle.component.html',
  styleUrl: './driver-vehicle.component.css'
})
export class DriverVehicleComponent implements OnInit{
  driverListBool: boolean = false
  managerService = inject(ManagerServiceService)

  drivers?: Driver[]
  @Input() idVehicle?:string|null;

  changeDriverList():void{
    this.driverListBool = !this.driverListBool
  }

  ngOnInit(): void {
    this.managerService.getDriversWithoutVehicle().subscribe(payload=>{
      this.drivers = payload
    })
  }

  insertDriverVehicle(username?: string|null){
    let driverVehicle : DriverVehicle = {
      idDriver:username,
      idVehicle:this.idVehicle
    }
    this.managerService.addDriverVehicle(driverVehicle).subscribe(payload=>{
      console.log(payload)
      location.reload()
    })
  }
}
