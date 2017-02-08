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
var PropuestaService = (function () {
    function PropuestaService(http) {
        this.http = http;
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
    }
    PropuestaService.prototype.getPropuesta = function () {
        return this.http.get('/Portal-Permutas/api/propuesta/findOne').map(this.extractData).publish().refCount();
    };
    PropuestaService.prototype.createZone = function (zona) {
        console.log(zona);
        return this.http.post('/Portal-Permutas/api/zonaDeseada', zona).subscribe(function (response) { });
    };
    PropuestaService.prototype.checkCoincidencias = function () {
        return this.http.get('/Portal-Permutas/api/zonaDeseada/matchings').map(this.extractData).publish().refCount();
    };
    PropuestaService.prototype.extractData = function (res) {
        var body = res.json();
        return body || {};
    };
    PropuestaService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], PropuestaService);
    return PropuestaService;
}());
exports.PropuestaService = PropuestaService;
//# sourceMappingURL=propuesta.service.js.map