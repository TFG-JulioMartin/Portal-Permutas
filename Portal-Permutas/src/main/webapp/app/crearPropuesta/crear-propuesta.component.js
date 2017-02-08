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
var index_1 = require('../_services/index');
var zona_deseada_component_1 = require('../zonasDeseadas/zona-deseada.component');
var CrearPropuestaComponent = (function () {
    function CrearPropuestaComponent(router, propuestaService, alertService, zonaDeseadaComponent) {
        this.router = router;
        this.propuestaService = propuestaService;
        this.alertService = alertService;
        this.zonaDeseadaComponent = zonaDeseadaComponent;
        this.model = {};
        this.loading = false;
        this.setId(this.id);
        console.log(this.zonaDeseadaComponent.getIdDestino());
    }
    CrearPropuestaComponent.prototype.setId = function (id) {
        id = this.zonaDeseadaComponent.getIdDestino();
    };
    CrearPropuestaComponent.prototype.getPropuesta = function () {
        var _this = this;
        this.propuestaService.getPropuesta().subscribe(function (propuesta) { return _this.propuesta = propuesta; });
    };
    CrearPropuestaComponent.prototype.crearPropuesta = function () {
        var _this = this;
        this.loading = true;
        this.userService.update(this.principal)
            .subscribe(function (data) {
            _this.alertService.success('Registration successful', true);
            _this.router.navigate(['/home']);
        }, function (error) {
            _this.alertService.error(error);
            _this.loading = false;
        });
    };
    CrearPropuestaComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            templateUrl: 'crear-propuesta.component.html'
        }), 
        __metadata('design:paramtypes', [router_1.Router, index_1.PropuestaService, index_1.AlertService, zona_deseada_component_1.ZonaDeseadaComponent])
    ], CrearPropuestaComponent);
    return CrearPropuestaComponent;
}());
exports.CrearPropuestaComponent = CrearPropuestaComponent;
//# sourceMappingURL=crear-propuesta.component.js.map