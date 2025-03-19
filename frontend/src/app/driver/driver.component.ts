import { Component, OnInit,inject } from '@angular/core';
import { DriverServiceService } from '../service/driver-service.service';
import { ActivatedRoute } from '@angular/router';
import { UserCardComponent } from '../components/user-card/user-card.component';
import { Driver } from '../model/driver.model';
import { TableDriverComponent } from '../components/table-driver/table-driver.component';
import { NgIf,CommonModule } from '@angular/common';
@Component({
  selector: 'app-driver',
  imports: [NgIf,CommonModule,UserCardComponent,TableDriverComponent],
  templateUrl: './driver.component.html',
  styleUrl: './driver.component.css'
})
export class DriverComponent implements OnInit{
  service = inject(DriverServiceService)
  id : string|null = ""
  route = inject(ActivatedRoute)
  driver! : Driver;

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");
    this.service.getDriver(this.id).subscribe( payload => {
      this.driver = payload;
    })
  }

  waiting: boolean = true;
  accepted: boolean = false;
  delivered: boolean = false;
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
