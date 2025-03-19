import { NgClass } from '@angular/common';
import { Component, Input,inject } from '@angular/core';
import { FormControl, FormGroup,Validators,ReactiveFormsModule } from '@angular/forms';
import { ServiceService } from '../../service/service.service';
import { PackageDto } from '../../model/package-dto.model';
@Component({
  selector: 'app-package-grade',
  imports: [NgClass,ReactiveFormsModule],
  templateUrl: './package-grade.component.html',
  styleUrl: './package-grade.component.css'
})
export class PackageGradeComponent {

  @Input() idPackage?: number;

  service = inject(ServiceService)

  classModal : boolean = true;
  modalActive() : void{
    console.log("Activated modal")
    if(this.classModal)
      this.classModal = false
    else
      this.classModal = true
  }

  formGroup = new FormGroup ({
    grade:new FormControl('',[Validators.required]),
    comment:new FormControl('')
  })

  updatePackage(){
    let packageDto : PackageDto = {
      idPackage:this.idPackage,
      grade: Number(this.formGroup.get('grade')?.value),
      comment: this.formGroup.get('comment')?.value
    }
    this.service.ratePackage(packageDto).subscribe(payload=>{
      console.log(payload)
    })
  }
}
