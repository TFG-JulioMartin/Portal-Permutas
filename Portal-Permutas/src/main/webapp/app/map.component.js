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
    }
    MapComponent.prototype.ngOnInit = function () {
        this.getPlazas();
        this.getCoords();
    };
    MapComponent.prototype.getPlazas = function () {
        var _this = this;
        this.plazaService.getPlazas().subscribe(function (plazas) { return _this.plazas = plazas; });
    };
    MapComponent.prototype.getCoords = function () {
        this.geocodingService.codeAddress(this.address);
    };
    MapComponent.prototype.clickedMarker = function (label, index) {
        console.log("clicked the marker: " + (label || index));
    };
    MapComponent.prototype.mapClicked = function ($event) {
        this.markers.push({
            lat: $event.coords.lat,
            lng: $event.coords.lng
        });
    };
    MapComponent.prototype.markerDragEnd = function (m, $event) {
        console.log('dragEnd', m, $event);
    };
    MapComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'g-map',
            styles: ["\n    .sebm-google-map-container {\n       height: 600px;\n     }\n  "],
            templateUrl: 'map.component.html'
        }), 
        __metadata('design:paramtypes', [plaza_service_1.PlazaService, index_1.GeocodingService, router_1.Router])
    ], MapComponent);
    return MapComponent;
}());
exports.MapComponent = MapComponent;
//# sourceMappingURL=map.component.js.map