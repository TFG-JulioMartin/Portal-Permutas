"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var AppComponent = (function () {
    function AppComponent() {
    }
    AppComponent = __decorate([
        core_1.Component({
            selector: 'my-app',
            template: "<h1>Welcome</h1>\n  <nav>\n      <button><a routerLink=\"/login\" routerLinkActive=\"active\">Login</a></button>\n      <button><a routerLink=\"/register\" routerLinkActive=\"active\">Register</a></button>\n      <button><a routerLink=\"/\" routerLinkActive=\"active\">Home</a></button>\n      <button><a routerLink=\"/list\" routerLinkActive=\"active\">Listado</a></button>\n      <button><a routerLink=\"/zonas\" routerLinkActive=\"active\">Zonas</a></button>\n      <button><a routerLink=\"/editaUsuario\" routerLinkActive=\"active\">Editar Usuario</a></button>\n  </nav>\n  \n  <br>\n  <router-outlet></router-outlet>\n  ",
            styles: [
                'nav { margin-left: 40%; }',
                'h1 { margin-left: 47%; }'
            ]
        }), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map