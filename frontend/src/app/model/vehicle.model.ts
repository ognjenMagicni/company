import { Driver } from "./driver.model";

export interface Vehicle{
    idVehicle?:string|null,
    fkDriver?:Driver,
    registrationStart?:Date|null,
    registrationEnd?:Date|null,
    year?:number|null,
    km?:number|null,
    boot?:number|null,
    dateSmallServiceLast?:Date|null,
    dateBigServiceLast?:Date|null
}