import { Component,Input,OnInit,inject } from '@angular/core';
import { ServiceService } from '../../service/service.service';
import { Package } from '../../model/package.model';
import { PackageGradeComponent } from '../package-grade/package-grade.component';
import { CommonModule, NgIf } from '@angular/common';

@Component({
  selector: 'app-table',
  imports: [PackageGradeComponent,NgIf,CommonModule],
  templateUrl: './table.component.html',
  styleUrl: './table.component.css'
})

export class TableComponent implements OnInit{
  @Input() username!: string|null;
  @Input() type!: string|null;
  service = inject(ServiceService)
  packages!: Package[];
  ngOnInit(): void {
    this.service.getPackages(this.username,this.type).subscribe( payload => {
      this.packages = payload
      console.log(this.packages)
    })
  }

  deletePackage(idPackage?: number): void{
    console.log("Delete has started")
    this.service.deletePackage(this.username,idPackage).subscribe(payload => {
      console.log(payload)
      location.reload()
    })
  }
  ratePackage(){
    
  }
} 
