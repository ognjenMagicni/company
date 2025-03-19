export interface Package {
    idPackage?: number;
    title?: string|null;
    weight?: number|null;
    height?: number|null;
    width?: number|null;
    length?: number|null;
    cityStart?: number|null;
    cityEnd?: number|null;
    dateStart?: string|null; 
    price?: number|null;
    stage?: number|null;
    addressStart?: string|null;
    addressEnd?: string|null;
    fkUser?: string |null;
    grade?:number,
    comment?:string
}