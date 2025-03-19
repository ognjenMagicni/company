import { Component,inject, OnInit,Input } from '@angular/core';
import { Package } from '../../model/package.model';
import { DriverServiceService } from '../../service/driver-service.service';
import { NgIf, CommonModule } from '@angular/common';
@Component({
  selector: 'app-table-driver',
  imports: [NgIf,CommonModule],
  templateUrl: './table-driver.component.html',
  styleUrl: './table-driver.component.css'
})
export class TableDriverComponent implements OnInit{
  packages!: Package[];
  @Input() username!: string|null;
  @Input() type!: string|null;
  service = inject(DriverServiceService)

  ngOnInit(): void{
    this.service.getAllWaitingPackages(this.username,this.type).subscribe(payload=>{
      this.packages = payload;
    })
  }

  acceptPackage(idPackage?:number){
    this.service.waiting2accepted(this.username,idPackage).subscribe(payload=>{
      console.log(payload)
    })
    location.reload()
  }
  deliverPackage(idPackage?:number){
    this.service.accepted2delivered(this.username,idPackage).subscribe(payload=>{
      console.log(payload)
    })
    location.reload()
  }
}
