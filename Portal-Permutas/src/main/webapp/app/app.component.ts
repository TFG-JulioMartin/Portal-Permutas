import { Component } from '@angular/core';
import { User } from './_models/index';
import {Router} from '@angular/router';

import { AuthenticationService } from './_services/index';


@Component({
  selector: 'my-app',
  template: `<div *ngIf="!this.authenticationService.isLoggedIn()"><h1>Welcome</h1></div>
             <div *ngIf="this.authenticationService.isLoggedIn()"><h1>Welcome {{currentUser.nombre}}!</h1></div>
             <div>{{this.authenticationService.isLoggedIn()}}</div>
  <nav>
   <div *ngIf="!this.authenticationService.isLoggedIn()">
    <button><a routerLink="/" routerLinkActive="active">Home</a></button>
    <button><a routerLink="/login" routerLinkActive="active">Login</a></button>
    <button><a routerLink="/register" routerLinkActive="active">Register</a></button>
    </div>
    <div *ngIf="this.authenticationService.isLoggedIn()">
    <button><a routerLink="/" routerLinkActive="active">Home</a></button>
    <button><a routerLink="/list" routerLinkActive="active">Listado</a></button>
    <button><a routerLink="/zonas" routerLinkActive="active">Zonas</a></button>
    <button><a routerLink="/editaUsuario" routerLinkActive="active">Editar Usuario</a></button>
    <button><a routerLink="/editaPlaza" routerLinkActive="active">Editar Plaza</a></button>
    <button (click)='logout()'>Logout ({{currentUser.username}})</button>
    </div>
  </nav>
  
  <br>
  <router-outlet></router-outlet>
  `,
  styles: [
  
  'nav { margin-left: 35%; }',
  'h1 { margin-left: 47%; }'
  
  ]
})
export class AppComponent { 

	currentUser: User;
    loggedIn: any;
    
    constructor(private authenticationService: AuthenticationService, private router: Router) {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        this.loggedIn = this.authenticationService.isLoggedIn();
    }
    
    logout() {
        this.router.navigate(['/j_spring_security_logout']);
        this.authenticationService.changeLoginStatus(false);
        localStorage.removeItem('currentUser');
    }


}