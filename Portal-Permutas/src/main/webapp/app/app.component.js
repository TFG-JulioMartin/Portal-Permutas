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
var index_2 = require('./_services/index');
var AppComponent = (function () {
    function AppComponent(authenticationService, router, _element, propuestaService) {
        this.authenticationService = authenticationService;
        this.router = router;
        this._element = _element;
        this.propuestaService = propuestaService;
        this.NotLoggedNavItems = [
            { name: 'Home', route: '' },
            { name: 'List', route: 'list' },
            { name: 'Login', route: 'login' },
            { name: 'Register', route: 'register' }
        ];
        this.LoggedNavItems = [
            { name: 'Home', route: '' },
            { name: 'List', route: 'list' },
            { name: 'Zonas Deseadas', route: 'zonas' },
            { name: 'Editar Perfil', route: 'editaUsuario' },
            { name: 'Editar Plaza', route: 'editaPlaza' },
            { name: 'Propuestas Enviadas', route: 'propuestasEnviadas' },
            { name: 'Propuestas Recibidas', route: 'propuestasRecibidas' }
        ];
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        this.loggedIn = this.authenticationService.isLoggedIn();
        this.getNumeroPropuestasEnviadas();
        this.getNumeroPropuestasRecibidas();
    }
    AppComponent.prototype.getNumeroPropuestasEnviadas = function () {
        var _this = this;
        this.propuestaService.getPropuestasEnviadasN().subscribe(function (numPE) { return _this.numPE = numPE; });
    };
    AppComponent.prototype.getNumeroPropuestasRecibidas = function () {
        var _this = this;
        this.propuestaService.getPropuestasRecibidasN().subscribe(function (numPR) { return _this.numPR = numPR; });
    };
    AppComponent.prototype.logout = function () {
        this.router.navigate(['/j_spring_security_logout']);
        this.authenticationService.changeLoginStatus(false);
        localStorage.removeItem('currentUser');
    };
    AppComponent.prototype.goToLogin = function () {
        this.router.navigate(['/login']);
    };
    AppComponent.prototype.goToRegister = function () {
        this.router.navigate(['/register']);
    };
    AppComponent.prototype.goToHome = function () {
        this.router.navigate(['/']);
    };
    AppComponent.prototype.goToEditarUsuario = function () {
        this.router.navigate(['/editaUsuario']);
    };
    AppComponent.prototype.goToRecibidas = function () {
        this.router.navigate(['/propuestasRecibidas']);
    };
    AppComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'my-app',
            templateUrl: 'app.component.html',
            styleUrls: ['app.component.css'],
            encapsulation: core_1.ViewEncapsulation.None,
        }), 
        __metadata('design:paramtypes', [index_1.AuthenticationService, router_1.Router, core_1.ElementRef, index_2.PropuestaService])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map