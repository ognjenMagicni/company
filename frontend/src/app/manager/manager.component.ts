import { Component, OnInit,inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ManagerServiceService } from '../service/manager-service.service';
import { UserCardComponent } from '../components/user-card/user-card.component';
import { Manager } from '../model/manager.model';
import { VehiclesComponent } from '../vehicles/vehicles.component';
import { VehicleModalComponent } from '../components/vehicle-modal/vehicle-modal.component';
@Component({
  selector: 'app-manager',
  imports: [VehiclesComponent,UserCardComponent,VehicleModalComponent],
  templateUrl: './manager.component.html',
  styleUrl: './manager.component.css'
})
export class ManagerComponent implements OnInit{
  route = inject(ActivatedRoute)
  service = inject(ManagerServiceService);

  id!:string|null;
  manager!:Manager

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id");
    this.service.getManager(this.id).subscribe( payload => {
      this.manager = payload;
    })
  }

  type: string = "vehicles"
  changeType(value:string){
    this.type = value;
  }

  vehicle: boolean = true;
  smallService: boolean = false;
  bigService: boolean = false;
  km: boolean = false;
  year: boolean = false;
  
  vehicleClick():void{
    this.vehicle = false;
    this.smallService = true;
    this.bigService = false;
    this.km = false;
    this.year = false;
  }
  smallClick():void{
    this.vehicle = false;
    this.smallService = true;
    this.bigService = false;
    this.km = false;
    this.year = false;
  }
  bigClick():void{
    this.vehicle = false;
    this.smallService = true;
    this.bigService = false;
    this.km = false;
    this.year = false;
  }
  kmClick():void{
    this.vehicle = false;
    this.smallService = true;
    this.bigService = false;
    this.km = false;
    this.year = false;
  }
  yearClick():void{
    this.vehicle = false;
    this.smallService = true;
    this.bigService = false;
    this.km = false;
    this.year = false;
  }
  
}
