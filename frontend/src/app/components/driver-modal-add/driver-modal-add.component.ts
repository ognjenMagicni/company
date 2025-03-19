import { Component, inject, Input } from '@angular/core';
import { Driver } from '../../model/driver.model';
import { ManagerServiceService } from '../../service/manager-service.service';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserReg } from '../../model/user-reg.model';
import { CommonModule, NgClass, NgIf } from '@angular/common';

@Component({
  selector: 'app-driver-modal-add',
  imports: [NgIf,CommonModule,NgClass,ReactiveFormsModule],
  templateUrl: './driver-modal-add.component.html',
  styleUrl: './driver-modal-add.component.css'
})
export class DriverModalAddComponent {
    managerService = inject(ManagerServiceService)
  
    classModal : boolean = true;
      modalActive() : void{
        console.log("Activated modal")
        if(this.classModal)
          this.classModal = false
        else
          this.classModal = true
      }
    
      formGroup = new FormGroup ({
        username:new FormControl('',[Validators.required]),
        password:new FormControl('',[Validators.required]),
        name:new FormControl('',[Validators.required]),
        surname:new FormControl('',[Validators.required]),
      })
  
      addDriver(){
        let userReg: UserReg = this.formGroup.value;
        this.managerService.addDriver(userReg).subscribe(payload=>{
          console.log(payload)
        })
      }
      
}
