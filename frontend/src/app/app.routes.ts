import { Routes } from '@angular/router';
import { RegisterUserComponent } from './register-user/register-user.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { DriverComponent } from './driver/driver.component';
import { ManagerComponent } from './manager/manager.component';

export const routes: Routes = [
    {path:"login",component:LoginComponent},
    {path:"register",component:RegisterUserComponent},
    {path:"user/:id",component:UserComponent},
    {path:"driver/:id",component:DriverComponent},
    {path:"manager/:id",component:ManagerComponent},
    {path:"**",component:PageNotFoundComponent}
];
