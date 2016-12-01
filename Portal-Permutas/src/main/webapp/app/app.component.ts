import { Component } from '@angular/core';


@Component({
  selector: 'my-app',
  template: `<h1>Welcome</h1>
  <hello-user></hello-user>
  <nav>
      <a routerLink="/login" routerLinkActive="active">Login</a>
      <a routerLink="/register" routerLinkActive="active">Register</a>
  </nav>
  
  <br>
  <div class="container">
  <g-map></g-map>
  </div>
  <router-outlet></router-outlet>
  `
})
export class AppComponent { }
