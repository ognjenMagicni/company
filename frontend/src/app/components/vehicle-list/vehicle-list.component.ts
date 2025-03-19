import { Component, Input,OnInit,inject } from '@angular/core';
import { Vehicle } from '../../model/vehicle.model';
import { CommunicationServiceService } from '../../service/communication-service.service';
import { CommonModule, NgIf } from '@angular/common';

@Component({
  selector: 'app-vehicle-list',
  imports: [NgIf, CommonModule],
  templateUrl: './vehicle-list.component.html',
  styleUrl: './vehicle-list.component.css'
})
export class VehicleListComponent{
  communicationService = inject(CommunicationServiceService)

  @Input() v!: Vehicle;
  @Input() type!: string;

  driverVehicleClick(type:string,username?:string|null){
    console.log("vehicle-list driverVehicleClick")
    this.communicationService.driverVehicleClick(type,username)
  }

}
