import { NgModule, ApplicationRef } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppComponent }   from './app.component';
import { HelloUserComponent }   from './hello-user.component';
import { MapComponent }   from './map.component';
import { AgmCoreModule } from 'angular2-google-maps/core';
@NgModule({
  imports: [ BrowserModule, AgmCoreModule.forRoot({
      apiKey: 'AIzaSyA0Bx2IH546c7E3E5mqtSwQq8z-inqpWts'
    }) ],
  declarations: [ AppComponent, HelloUserComponent, MapComponent  ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
