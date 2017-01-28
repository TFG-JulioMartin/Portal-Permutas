import { NgModule, ApplicationRef } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent }   from './app.component';
import { HelloUserComponent }   from './hello-user.component';
import { MapComponent }   from './map.component';
import { AgmCoreModule } from 'angular2-google-maps/core';
import { LoginComponent }   from './login/login.component';
import { RegisterComponent }   from './register/register.component';
import { PlazasListComponent }   from './listadoPlazas/plazas-list.component';

import { AlertComponent } from './_directives/index';
import { AlertService, AuthenticationService, UserService } from './_services/index';
import { PlazaService } from './listadoPlazas/plaza.service';

import { AppRoutingModule }     from './app-routing.module';

@NgModule({
  imports: [ BrowserModule, FormsModule, HttpModule, AppRoutingModule, AgmCoreModule.forRoot({
      apiKey: 'AIzaSyA0Bx2IH546c7E3E5mqtSwQq8z-inqpWts'
    }) ],
  declarations: [ AppComponent, AlertComponent, HelloUserComponent, PlazasListComponent, MapComponent, LoginComponent, RegisterComponent ],
  providers: [
        AlertService,
        AuthenticationService,
        PlazaService,
        UserService,
    ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
