import { Component } from '@angular/core';


@Component({
  selector: 'my-app',
  template: `<h1>Welcome</h1>
  <nav>
      <button><a routerLink="/login" routerLinkActive="active">Login</a></button>
      <button><a routerLink="/register" routerLinkActive="active">Register</a></button>
      <button><a routerLink="/" routerLinkActive="active">Home</a></button>
      <button><a routerLink="/list" routerLinkActive="active">Listado</a></button>
      <button><a routerLink="/zonas" routerLinkActive="active">Zonas</a></button>
      <button><a routerLink="/editaUsuario" routerLinkActive="active">Editar Usuario</a></button>
      <button><a routerLink="/crearPropuesta" routerLinkActive="active">CrearPropuesta</a></button>
  </nav>
  
  <br>
  <router-outlet></router-outlet>
  `,
  styles: [
  
  'nav { margin-left: 40%; }',
  'h1 { margin-left: 47%; }'
  
  ]
})
export class AppComponent { }