"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
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
var core_2 = require('angular2-google-maps/core');
var core_3 = require('angular2-google-maps/core');
var Observable_1 = require('rxjs/Observable');
var GeocodingService = (function (_super) {
    __extends(GeocodingService, _super);
    function GeocodingService(__loader, __zone) {
        var _this = this;
        _super.call(this, __loader, __zone);
        this.__loader = __loader;
        this.__zone = __zone;
        this.__loader.load().then(function () {
            console.log('google script loaded');
            _this.geocoder = new google.maps.Geocoder();
        });
    }
    GeocodingService.prototype.getLatLan = function (address) {
        var geo = this.geocoder;
        return new Observable_1.Observable(function (observer) {
            geo.geocode({ 'address': address }, (function (results, status) {
                if (status === google.maps.GeocoderStatus.OK) {
                    observer.next(results);
                    observer.complete();
                }
                else {
                    console.log('Geocoding service: geocode was not successful for the following reason: ' + status);
                    observer.error(status);
                }
            }));
        });
    };
    GeocodingService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [core_3.MapsAPILoader, core_1.NgZone])
    ], GeocodingService);
    return GeocodingService;
}(core_2.GoogleMapsAPIWrapper));
exports.GeocodingService = GeocodingService;
//# sourceMappingURL=geocoding.service.js.map