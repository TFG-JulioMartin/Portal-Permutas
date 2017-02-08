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
import { ZonaDeseadaComponent }      from './zonasDeseadas/zona-deseada.component';
import { EditarUsuarioComponent }      from './editarUsuario/editar-usuario.component';
import { CrearPropuestaComponent }      from './crearPropuesta/crear-propuesta.component';

import { AlertComponent } from './_directives/index';
import { AlertService, AuthenticationService, UserService, GeocodingService, PropuestaService} from './_services/index';
import { PlazaService } from './listadoPlazas/plaza.service';
import { ZonaDeseadaService } from './zonasDeseadas/zona-deseada.service';
import { GoogleMapsAPIWrapper } from 'angular2-google-maps/core';

import { AppRoutingModule }     from './app-routing.module';

@NgModule({
  imports: [ BrowserModule, FormsModule, HttpModule, AppRoutingModule, AgmCoreModule.forRoot({
      apiKey: 'AIzaSyA0Bx2IH546c7E3E5mqtSwQq8z-inqpWts'
    }) ],
  declarations: [
  		AppComponent,
  		AlertComponent,
  		HelloUserComponent,
  		PlazasListComponent,
  		MapComponent,
  		LoginComponent,
  		RegisterComponent, 
  		ZonaDeseadaComponent,
  		CrearPropuestaComponent,
  		EditarUsuarioComponent 
  	],
  providers: [
        AlertService,
        AuthenticationService,
        PlazaService,
        ZonaDeseadaService,
        GeocodingService,
        GoogleMapsAPIWrapper,
        PropuestaService,
        ZonaDeseadaComponent,
        CrearPropuestaComponent,
        UserService,
    ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
