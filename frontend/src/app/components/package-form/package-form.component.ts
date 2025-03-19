import { Component,Input,inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NgClass } from '@angular/common';
import { ServiceService } from '../../service/service.service';
import { Package } from '../../model/package.model';
@Component({
  selector: 'app-package-form',
  imports: [NgClass,ReactiveFormsModule],
  templateUrl: './package-form.component.html',
  styleUrl: './package-form.component.css'
})
export class PackageFormComponent {
  @Input() username? : string| null;
  service = inject(ServiceService)

  classModal : boolean = true;
  modalActive() : void{
    console.log("Activated modal")
    if(this.classModal)
      this.classModal = false
    else
      this.classModal = true
  }

  formGroup = new FormGroup({
    title: new FormControl('',Validators.required),
    weight: new FormControl(0,Validators.required),
    height: new FormControl(0,Validators.required),
    width: new FormControl(0,Validators.required),
    length: new FormControl(0,Validators.required),
    addressStart: new FormControl('',Validators.required),
    addressEnd: new FormControl('',Validators.required),
  })

  insertPackage():void{
    let packageObj : Package = {
      title: this.formGroup.get("title")?.value,
      weight: this.formGroup.get("weight")?.value,
      height: this.formGroup.get("height")?.value,
      width: this.formGroup.get("width")?.value,
      length: this.formGroup.get("length")?.value,
      addressStart: this.formGroup.get("addressStart")?.value,
      addressEnd: this.formGroup.get("addressEnd")?.value,
      fkUser: this.username
    }
    console.log(packageObj)
    this.service.insertPackage(packageObj).subscribe( payload => {
      console.log(payload)
    })
    location.reload()
  }


}
