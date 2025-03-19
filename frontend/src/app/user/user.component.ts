import { Component, inject, OnInit } from '@angular/core';
import { ServiceService } from '../service/service.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../model/user.model';
import { Package } from '../model/package.model';
import { UserCardComponent } from '../components/user-card/user-card.component';
import { NgIf, CommonModule, NgClass} from '@angular/common';
import { TableComponent } from '../components/table/table.component';
import { PackageFormComponent } from '../components/package-form/package-form.component';
import { PackageGradeComponent } from '../components/package-grade/package-grade.component';
@Component({
  selector: 'app-user',
  imports: [NgClass,PackageFormComponent, TableComponent,UserCardComponent,NgIf,CommonModule, PackageGradeComponent],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit{
  route = inject(ActivatedRoute)
  service = inject(ServiceService);

  id !: string | null
  user!: User
  waitingPackages !: Package[]
  acceptedPackages !: Package[]
  deliveredPackages !: Package[]

  waiting: boolean = true;
  accepted: boolean = false;
  delivered: boolean = false;

  

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");
    this.service.getUser(this.id).subscribe( payload => {
      this.user = payload
    })
  }

  waitingClick():void{
    this.waiting = true;
    this.accepted = false;
    this.delivered = false;
  }

  acceptedClick():void{
    this.waiting = false;
    this.accepted = true;
    this.delivered = false;
  }

  deliveredClick():void{
    this.waiting = false;
    this.accepted = false;
    this.delivered = true;
  }
}
