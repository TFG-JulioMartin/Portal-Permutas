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
var http_1 = require('@angular/http');
require('rxjs/add/operator/toPromise');
var ZonaDeseadaService = (function () {
    function ZonaDeseadaService(http) {
        this.http = http;
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
    }
    ZonaDeseadaService.prototype.getZonas = function () {
        return this.http.get('/Portal-Permutas/api/zonaDeseada/all').map(function (res) { return res.json(); });
    };
    ZonaDeseadaService.prototype.createZone = function (circles) {
        console.log(circles);
        return this.http.post('/Portal-Permutas/api/zonaDeseada', circles).map(function (res) { return res.json(); });
    };
    ZonaDeseadaService.prototype.deleteZone = function (id) {
        return this.http.delete('/Portal-Permutas/api/zonaDeseada/' + id)
            .toPromise()
            .then(function () { return null; }).catch(this.handleError);
    };
    ZonaDeseadaService.prototype.checkCoincidencias = function () {
        return this.http.get('/Portal-Permutas/api/zonaDeseada/matchings').map(this.extractData).publish().refCount();
    };
    ZonaDeseadaService.prototype.extractData = function (res) {
        var body = res.json();
        return body || {};
    };
    ZonaDeseadaService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], ZonaDeseadaService);
    return ZonaDeseadaService;
}());
exports.ZonaDeseadaService = ZonaDeseadaService;
//# sourceMappingURL=zona-deseada.service.js.map