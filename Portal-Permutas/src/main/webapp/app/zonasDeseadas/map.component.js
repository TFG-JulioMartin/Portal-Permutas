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
var plaza_service_1 = require('./listadoPlazas/plaza.service');
var index_1 = require('./_services/index');
var router_1 = require('@angular/router');
var MapComponent = (function () {
    function MapComponent(plazaService, geocodingService, router) {
        this.plazaService = plazaService;
        this.geocodingService = geocodingService;
        this.router = router;
        this.address = 'Plaza Vicente Aleixandre, Sevilla';
        this.latitude = 37.3694661;
        this.zoom = 13;
        // initial center position for the map
        this.lat = 37.362444;
        this.lng = -5.9965;
    }
    MapComponent.prototype.ngOnInit = function () {
        this.getPlazas();
    };
    MapComponent.prototype.getPlazas = function () {
        var _this = this;
        this.plazaService.getPlazas().subscribe(function (plazas) { return _this.plazas = plazas; });
    };
    MapComponent.prototype.search = function () {
        var _this = this;
        this.geocodingService.getLatLan('Plaza Vicente Aleixandre, Sevilla').subscribe(function (data) {
            _this.latitude = data.results[0].geometry.location.lat;
        });
    };
    MapComponent.prototype.clickedMarker = function (label, index) {
        console.log("clicked the marker: " + (label || index));
    };
    MapComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'g-map',
            styles: ["\n    .sebm-google-map-container {\n       height: 600px;\n     }\n  "],
            templateUrl: 'map.component.html'
        }), 
        __metadata('design:paramtypes', [(typeof (_a = typeof plaza_service_1.PlazaService !== 'undefined' && plaza_service_1.PlazaService) === 'function' && _a) || Object, (typeof (_b = typeof index_1.GeocodingService !== 'undefined' && index_1.GeocodingService) === 'function' && _b) || Object, router_1.Router])
    ], MapComponent);
    return MapComponent;
    var _a, _b;
}());
exports.MapComponent = MapComponent;
//# sourceMappingURL=map.component.js.map