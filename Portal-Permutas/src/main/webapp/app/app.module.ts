import { NgModule, ApplicationRef } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AppComponent }   from './app.component';
import { HelloUserComponent }   from './hello-user.component';
import { MapComponent }   from './map.component';
import { AgmCoreModule } from 'angular2-google-maps/core';
import { LoginComponent }   from './login/login.component';
import { RegisterComponent }   from './register/register.component';

import { AppRoutingModule }     from './app-routing.module';

@NgModule({
  imports: [ BrowserModule,  AppRoutingModule, AgmCoreModule.forRoot({
      apiKey: 'AIzaSyA0Bx2IH546c7E3E5mqtSwQq8z-inqpWts'
    }) ],
  declarations: [ AppComponent, HelloUserComponent, MapComponent, LoginComponent, RegisterComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
