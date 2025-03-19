import { Component, inject } from '@angular/core';
import { FormGroup,Validators,FormControl,ReactiveFormsModule } from '@angular/forms';
import { ServiceService } from '../service/service.service';
import { Login } from '../model/login.model';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  service = inject(ServiceService)
  router = inject(Router)
  loginForm = new FormGroup({
      username : new FormControl('',[Validators.required]),
      password : new FormControl('',[Validators.required]),
    });

  onSubmit(): void{
    let login: Login = {
      username: this.loginForm.get("username")?.value,
      password: this.loginForm.get("password")?.value
    }
    localStorage.setItem('jwt','')
    this.service.loginUser(login).subscribe( payload => {
      console.log(payload)
      if(payload.token){
        localStorage.setItem('jwt',payload.token)
      }
      if(payload.role==1)
        this.router.navigate(['user',payload.username])
      else if(payload.role==2){
        this.router.navigate(['driver',payload.username])
      }else if(payload.role==3){
        this.router.navigate(['manager',payload.username])
      }
    })
  }
}
 