import { EventEmitter, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommunicationServiceService {
  eventEmmiter = new EventEmitter<string>
  driverVehicleClick(type:string,username?:string|null){
    console.log("communication service runned")
    let message = type + " " + username;
    this.eventEmmiter.emit(message)
  }
}
