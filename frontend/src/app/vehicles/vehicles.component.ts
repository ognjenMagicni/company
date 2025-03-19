import { Input,Component,inject, OnInit } from '@angular/core';
import { ManagerServiceService } from '../service/manager-service.service';
import { Vehicle } from '../model/vehicle.model';
import { CommonModule, NgIf, provideCloudinaryLoader } from '@angular/common';
import { Observable } from 'rxjs';
import { Driver } from '../model/driver.model';
import { DriverServiceService } from '../service/driver-service.service';
import { Package } from '../model/package.model';
import { VehicleListComponent } from '../components/vehicle-list/vehicle-list.component';
import { CommunicationServiceService } from '../service/communication-service.service';
import { CommentComponent } from "../components/comment/comment.component";
import { VehicleModalComponent } from '../components/vehicle-modal/vehicle-modal.component';
import { DriverModalAddComponent } from "../components/driver-modal-add/driver-modal-add.component";
import { DriverModalEditComponent } from '../components/driver-modal-edit/driver-modal-edit.component';
import { DriverVehicleComponent } from '../components/driver-vehicle/driver-vehicle.component';
import { DriverVehicle } from '../model/driver-vehicle-model';
@Component({
  selector: 'app-vehicles',
  imports: [NgIf, CommonModule, VehicleListComponent, CommentComponent, DriverVehicleComponent,VehicleModalComponent, DriverModalAddComponent, DriverModalAddComponent,DriverModalEditComponent],
  templateUrl: './vehicles.component.html',
  styleUrl: './vehicles.component.css'
})
export class VehiclesComponent implements OnInit{
  service = inject(ManagerServiceService)
  driverService = inject(DriverServiceService)
  communicationService = inject(CommunicationServiceService)

  @Input() type: string = "vehicle"

  vehicles!:Vehicle[]
  vehicleSmall!:Vehicle[]
  vehicleBig!:Vehicle[]
  vehicleYear!:Vehicle[]
  vehicleKm!:Vehicle[]
  vehicleUnused!:Vehicle[]
  drivers!:Driver[]

  driver!:Driver
  grades!:Package[]
  vehicle!:Vehicle


  ngOnInit(): void {
    console.log("vehicle/ngOnInit")
    this.service.getVehicles().subscribe(payload=>{
      this.vehicles = payload
    })
    this.service.getVehiclesSmall().subscribe(payload => {
      this.vehicleSmall = payload;
    })
    this.service.getVehiclesBig().subscribe(payload => {
      this.vehicleBig = payload;
    })
    this.service.getVehiclesYear().subscribe(payload => {
      this.vehicleYear = payload;
    })
    this.service.getVehiclesKm().subscribe(payload => {
      this.vehicleKm = payload;
    })
    this.service.getVehiclesUnused().subscribe(payload => {
      this.vehicleUnused = payload;
    })
    this.service.getDrivers().subscribe(payload => {
      this.drivers = payload;
      
    })

    this.communicationService.eventEmmiter.subscribe(message => {
      let typeInput = message.split(" ")[0]
      let username = message.split(" ")[1]
      this.type = typeInput
  
      if(typeInput=='driver'){
        this.driverService.getDriver(username).subscribe(payload=>{
          this.driver=payload
        })
        this.grades = []
        console.log("vehicle/emmiter "+this.driver.idDriver)
        this.driverService.getAllWaitingPackages(this.driver.idDriver,'delivered').subscribe(payload=>{
          this.grades = payload
        })
      }else if(typeInput='vehicle'){
        console.log(username)
        this.service.getVehicle(username).subscribe(payload => {
          this.vehicle=payload;
          console.log(payload)
        })
      }
    })
  }



  changeType(typeInput: string, username?:string|null){
    console.log("vehicle/changeType")
    this.type = typeInput
    if(typeInput=='driver'){
      this.grades = []
      this.driverService.getDriver(username).subscribe(payload=>{
        this.driver=payload
      })
      this.driverService.getAllWaitingPackages(username,'delivered').subscribe(payload=>{
        this.grades = payload
      })
    }else if(typeInput='vehicle'){
      console.log(username)
      this.service.getVehicle(username).subscribe(payload => {
        this.vehicle=payload;
      })
    }
  }
  
  deleteVehicle(username?:string|null){
    //this.service.deleteVehicle(username).subscribe(payload=>{
      //console.log(payload)
      //location.reload()
    //})
    console.log("For security i disabled delete button")
  }
  deleteDriver(username?:string|null){
    this.service.deleteDriver(username).subscribe(payload=>{
      console.log(payload)
      location.reload()
    })
  }

  removeDriver(idVehiclee?:string|null,idDriverr?:string|null){
    let driverVehicle : DriverVehicle = {
          idDriver:idDriverr,
          idVehicle:idVehiclee
        }
    this.service.removeDriverVehicle(driverVehicle).subscribe(payload=>{
      console.log(payload)
      location.reload()
    })
  }


}
