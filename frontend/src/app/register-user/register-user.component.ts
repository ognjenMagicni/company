import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ServiceService } from '../service/service.service';
import { UserReg } from '../model/user-reg.model';
@Component({
  selector: 'app-register-user',
  imports: [ReactiveFormsModule],
  templateUrl: './register-user.component.html',
  styleUrl: './register-user.component.css'
})
export class RegisterUserComponent {
  service = inject(ServiceService)
  registerForm = new FormGroup({
    name : new FormControl('',[Validators.required]),
    surname : new FormControl('',[Validators.required]),
    username : new FormControl('',[Validators.required]),
    password : new FormControl('',[Validators.required]),
    confirmPassword : new FormControl('',[Validators.required])
  });


  onSubmit() {
    let user : UserReg = {
      name : this.registerForm.get('name')?.value,
      surname : this.registerForm.get('surname')?.value,
      username : this.registerForm.get('username')?.value,
      password : this.registerForm.get('password')?.value,
    }
    this.service.insertUser(user).subscribe(payload => {
      console.log(payload);
    })
  }
}
