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
var zona_deseada_service_1 = require('./zona-deseada.service');
var index_1 = require('../_services/index');
var ZonaDeseadaComponent = (function () {
    function ZonaDeseadaComponent(zonaDeseadaService, plazaService, router) {
        this.zonaDeseadaService = zonaDeseadaService;
        this.plazaService = plazaService;
        this.router = router;
        this.model = {};
        this.zoom = 13;
        // initial center position for the map
        this.lat = 37.362444;
        this.lng = -5.9965;
        this.markers = [
            {
                lat: 37.382444,
                lng: -5.99625,
                label: 'A',
                draggable: true
            },
            {
                lat: 37.3541545,
                lng: -5.9885772,
                label: 'A',
                draggable: true
            }
        ];
        this.getCoincidencias();
        this.getPlazas();
        this.getZonas();
    }
    ZonaDeseadaComponent.prototype.getPlazas = function () {
        var _this = this;
        this.plazaService.getPlazas().subscribe(function (plazas) { return _this.plazas = plazas; });
    };
    ZonaDeseadaComponent.prototype.getZonas = function () {
        var _this = this;
        this.zonaDeseadaService.getZonas().subscribe(function (zonas) { return _this.zonas = zonas; });
    };
    ZonaDeseadaComponent.prototype.getCoincidencias = function () {
        var _this = this;
        this.zonaDeseadaService.checkCoincidencias().subscribe(function (coincidencias) { return _this.coincidencias = coincidencias; });
    };
    ZonaDeseadaComponent.prototype.proponer = function (id) {
        this.idDestino = id;
        this.router.navigate(['/crearPropuesta', id]);
    };
    ZonaDeseadaComponent.prototype.clickedMarker = function (label, index) {
        console.log("clicked the marker: " + (label || index));
    };
    ZonaDeseadaComponent.prototype.mapClicked = function ($event) {
        this.slat = $event.coords.lat;
        this.slng = $event.coords.lng;
    };
    ZonaDeseadaComponent.prototype.mapRightCliked = function ($event) {
        this.elat = $event.coords.lat;
        this.elng = $event.coords.lng;
        this.model.slat = this.slat;
        this.model.slng = this.slng;
        this.model.elat = this.elat;
        this.model.elng = this.elng;
        this.zonaDeseadaService.createZone(this.model);
    };
    ZonaDeseadaComponent.prototype.createZone = function () {
        var _this = this;
        this.zonaDeseadaService.createZone(this.slat)
            .subscribe(function (data) {
            _this.router.navigate([_this.returnUrl]);
        }, function (error) {
            _this.alertService.error(error);
            _this.loading = false;
        });
    };
    ZonaDeseadaComponent.prototype.markerDragEnd = function (m, $event) {
        console.log('dragEnd', m, $event);
    };
    ZonaDeseadaComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            styles: ["\n    .sebm-google-map-container {\n       height: 600px;\n     }\n  "],
            templateUrl: 'zona-deseada.component.html'
        }), 
        __metadata('design:paramtypes', [zona_deseada_service_1.ZonaDeseadaService, index_1.PlazaService, router_1.Router])
    ], ZonaDeseadaComponent);
    return ZonaDeseadaComponent;
}());
exports.ZonaDeseadaComponent = ZonaDeseadaComponent;
//# sourceMappingURL=zona-deseada.component.js.map