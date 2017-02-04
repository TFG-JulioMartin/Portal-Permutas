import { Component } from '@angular/core';


@Component({
  selector: 'my-app',
  template: `<h1>Welcome</h1>
  <hello-user></hello-user>
  <nav>
      <a routerLink="/login" routerLinkActive="active">Login</a>
      <a routerLink="/register" routerLinkActive="active">Register</a>
      <a routerLink="/" routerLinkActive="active">Home</a>
      <a routerLink="/list" routerLinkActive="active">Listado</a>
      <a routerLink="/zonas" routerLinkActive="active">Zonas</a>
      <a routerLink="/editaUsuario" routerLinkActive="active">Editar Usuario</a>
  </nav>
  
  <br>
  <router-outlet></router-outlet>
  `
})
export class AppComponent { }