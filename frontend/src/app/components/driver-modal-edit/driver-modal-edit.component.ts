import { Component, inject, Input } from '@angular/core';
import { ManagerServiceService } from '../../service/manager-service.service';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule, NgClass, NgIf } from '@angular/common';
import { Driver } from '../../model/driver.model';

@Component({
  selector: 'app-driver-modal-edit',
  imports: [ReactiveFormsModule,NgIf,CommonModule,NgClass],
  templateUrl: './driver-modal-edit.component.html',
  styleUrl: './driver-modal-edit.component.css'
})
export class DriverModalEditComponent {
  managerService = inject(ManagerServiceService)
    
      @Input() driver!: Driver
      classModal : boolean = true;
        modalActive() : void{
          console.log("Activated modal")
          if(this.classModal)
            this.classModal = false
          else
            this.classModal = true
        }
      
        formGroup = new FormGroup ({
          idDriver:new FormControl("",[Validators.required]),
          name:new FormControl("",[Validators.required]),
          surname:new FormControl("",[Validators.required]),
          dateStart: new FormControl(new Date()),
          fkVehicle: new FormControl("")
        })
    
        editDriver(){
          let driver: Driver = this.formGroup.value;
          this.managerService.editDriver(driver).subscribe(payload=>{
            console.log(payload)
          })
        }
}
