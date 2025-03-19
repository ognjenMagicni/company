import { CommonModule, NgClass, NgIf } from '@angular/common';
import { Component,inject,Input } from '@angular/core';
import { FormControl,FormGroup,ReactiveFormsModule,Validators } from '@angular/forms';
import { ManagerServiceService } from '../../service/manager-service.service';
import { Vehicle } from '../../model/vehicle.model';
@Component({
  selector: 'app-vehicle-modal',
  imports: [NgClass,ReactiveFormsModule,NgIf,CommonModule],
  templateUrl: './vehicle-modal.component.html',
  styleUrl: './vehicle-modal.component.css'
})
export class VehicleModalComponent {
  managerService = inject(ManagerServiceService)
  @Input() vehicle!:Vehicle

  classModal : boolean = true;
    modalActive() : void{
      console.log("Activated modal")
      if(this.classModal)
        this.classModal = false
      else
        this.classModal = true
    }
  
    formGroup = new FormGroup ({
      idVehicle:new FormControl(this.vehicle?.idVehicle),
      boot:new FormControl(this.vehicle?.boot),
      year:new FormControl(this.vehicle?.year),
      km:new FormControl(this.vehicle?.km),
      registrationStart:new FormControl(this.vehicle?.registrationStart),
      registrationEnd:new FormControl(this.vehicle?.registrationEnd),
      dateSmallServiceLast:new FormControl(this.vehicle?.dateSmallServiceLast),
      dateBigServiceLast:new FormControl(this.vehicle?.dateBigServiceLast),
      fkDriver:new FormControl()
    })

    addVehicle(){
      let vehicle: Vehicle = this.formGroup.value;
      this.managerService.addVehicle(vehicle).subscribe(payload=>{
        console.log(payload)
      })
    }
    editVehicle(){
      let vehicle: Vehicle = this.formGroup.value;
      console.log(this.formGroup.value)
    }
}
