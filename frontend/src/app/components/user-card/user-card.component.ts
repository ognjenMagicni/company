import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';
import { PackageFormComponent } from '../package-form/package-form.component';
import { CommonModule, NgIf } from '@angular/common';
@Component({
  selector: 'app-user-card',
  imports: [PackageFormComponent,NgIf,CommonModule],
  templateUrl: './user-card.component.html',
  styleUrl: './user-card.component.css'
})
export class UserCardComponent{
  @Input() name?: string|null;
  @Input() surname?: string|null;
  @Input() username? : string|null;
  @Input() pathPicture!: string|null;
  @Input() role!: number|null
  
}
