import { Component, Input,OnInit,inject } from '@angular/core';
import { DriverServiceService } from '../../service/driver-service.service';
import { Package } from '../../model/package.model';
import { CommonModule, NgIf } from '@angular/common';
@Component({
  selector: 'app-comment',
  imports: [NgIf,CommonModule],
  templateUrl: './comment.component.html',
  styleUrl: './comment.component.css'
})
export class CommentComponent implements OnInit{
  @Input() idDriver?: string|null;
  driverService = inject(DriverServiceService)
  grades!:Package[]

  ngOnInit(): void {
    this.driverService.getAllWaitingPackages(this.idDriver,'delivered').subscribe(payload=>{
      this.grades = []
      this.grades = payload
      console.log("cooment "+this.idDriver)
      console.log(this.grades)
    })
  }


}
