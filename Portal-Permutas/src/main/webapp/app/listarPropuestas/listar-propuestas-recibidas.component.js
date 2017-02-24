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
require('rxjs/add/operator/switchMap');
var index_1 = require('../_services/index');
var ListarPropuestasRecibidasComponent = (function () {
    function ListarPropuestasRecibidasComponent(propuestaService, router, plazaService) {
        this.propuestaService = propuestaService;
        this.router = router;
        this.plazaService = plazaService;
        // initial center position for the map
        this.lat = 37.362444;
        this.lng = -5.9965;
        this.zoom = 13;
    }
    ListarPropuestasRecibidasComponent.prototype.ngOnInit = function () {
        this.getPropuestasRecibidas();
    };
    ListarPropuestasRecibidasComponent.prototype.getPropuestasRecibidas = function () {
        var _this = this;
        this.propuestaService.getPropuestasRecibidas().subscribe(function (propuestas) { _this.propuestas = propuestas; });
    };
    ListarPropuestasRecibidasComponent.prototype.getPlazaRemitente = function (id, texto) {
        var _this = this;
        this.textoPropuesta = texto;
        this.plazaService.getPlaza(id).subscribe(function (plazaRemitente) { return _this.plazaRemitente = plazaRemitente; });
    };
    ListarPropuestasRecibidasComponent.prototype.cerrar = function () {
        this.plazaRemitente = null;
    };
    ListarPropuestasRecibidasComponent.prototype.aceptar = function (id) {
        var _this = this;
        this.propuestaService.aceptarPropuesta(id).subscribe(function (data) {
            _this.getPropuestasRecibidas();
        }, function (error) {
            console.log(error);
        });
    };
    ListarPropuestasRecibidasComponent.prototype.rechazar = function (id) {
        var _this = this;
        this.propuestaService.rechazarPropuesta(id).subscribe(function (data) {
            _this.getPropuestasRecibidas();
        }, function (error) {
            console.log(error);
        });
    };
    ListarPropuestasRecibidasComponent.prototype.clickedMarker = function (label, index) {
        console.log("clicked the marker: " + (label || index));
    };
    ListarPropuestasRecibidasComponent.prototype.mapClicked = function ($event) {
    };
    ListarPropuestasRecibidasComponent.prototype.markerDragEnd = function (m, $event) {
        console.log('dragEnd', m, $event);
    };
    ListarPropuestasRecibidasComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            styles: ["\n    .sebm-google-map-container {\n       height: 600px;\n     }\n  "],
            templateUrl: 'listar-propuestas-recibidas.component.html'
        }), 
        __metadata('design:paramtypes', [index_1.PropuestaService, router_1.Router, index_1.PlazaService])
    ], ListarPropuestasRecibidasComponent);
    return ListarPropuestasRecibidasComponent;
}());
exports.ListarPropuestasRecibidasComponent = ListarPropuestasRecibidasComponent;
//# sourceMappingURL=listar-propuestas-recibidas.component.js.map