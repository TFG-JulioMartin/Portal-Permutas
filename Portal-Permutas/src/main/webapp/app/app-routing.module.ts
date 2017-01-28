import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent }   from './login/login.component';
import { RegisterComponent }      from './register/register.component';
import { AppComponent }      from './app.component';
import { MapComponent }      from './map.component';
import { PlazasListComponent }      from './listadoPlazas/plazas-list.component';

const routes: Routes = [
  { path: '', component: MapComponent},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'list', component: PlazasListComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}