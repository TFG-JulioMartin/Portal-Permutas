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
var router_1 = require('@angular/router');
var index_1 = require('./_services/index');
var AppComponent = (function () {
    function AppComponent(authenticationService, router) {
        this.authenticationService = authenticationService;
        this.router = router;
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        this.loggedIn = this.authenticationService.isLoggedIn();
    }
    AppComponent.prototype.logout = function () {
        this.router.navigate(['/j_spring_security_logout']);
        this.authenticationService.changeLoginStatus(false);
        localStorage.removeItem('currentUser');
    };
    AppComponent = __decorate([
        core_1.Component({
            selector: 'my-app',
            template: "<div *ngIf=\"!this.authenticationService.isLoggedIn()\"><h1>Welcome</h1></div>\n             <div *ngIf=\"this.authenticationService.isLoggedIn()\"><h1>Welcome {{currentUser.nombre}}!</h1></div>\n  <nav>\n   <div *ngIf=\"!this.authenticationService.isLoggedIn()\">\n    <button><a routerLink=\"/\" routerLinkActive=\"active\">Home</a></button>\n    <button><a routerLink=\"/login\" routerLinkActive=\"active\">Login</a></button>\n    <button><a routerLink=\"/register\" routerLinkActive=\"active\">Register</a></button>\n    </div>\n    <div *ngIf=\"this.authenticationService.isLoggedIn()\">\n    <button><a routerLink=\"/\" routerLinkActive=\"active\">Home</a></button>\n    <button><a routerLink=\"/list\" routerLinkActive=\"active\">Listado</a></button>\n    <button><a routerLink=\"/zonas\" routerLinkActive=\"active\">Zonas</a></button>\n    <button><a routerLink=\"/editaUsuario\" routerLinkActive=\"active\">Editar Usuario</a></button>\n    <button><a routerLink=\"/editaPlaza\" routerLinkActive=\"active\">Editar Plaza</a></button>\n    <button><a routerLink=\"/propuestasEnviadas\" routerLinkActive=\"active\">Propuestas Enviadas</a></button>\n    <button><a routerLink=\"/propuestasRecibidas\" routerLinkActive=\"active\">Propuestas Recibidas</a></button>\n    <button (click)='logout()'>Logout ({{currentUser.username}})</button>\n    </div>\n  </nav>\n  \n  <br>\n  <router-outlet></router-outlet>\n  ",
            styles: [
                'nav { margin-left: 35%; }',
                'h1 { margin-left: 47%; }'
            ]
        }), 
        __metadata('design:paramtypes', [index_1.AuthenticationService, router_1.Router])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map