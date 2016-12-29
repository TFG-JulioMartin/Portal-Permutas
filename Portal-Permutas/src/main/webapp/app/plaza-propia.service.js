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
require('rxjs/add/operator/map');
require('rxjs/add/operator/publish');
var PlazaPropiaService = (function () {
    function PlazaPropiaService(http) {
        this.http = http;
    }
    PlazaPropiaService.prototype.findPlazas = function (page, pageSize, sort) {
        var params = new http_1.URLSearchParams();
        params.set('size', "" + pageSize);
        params.set('page', "" + page);
        if (sort != null) {
            params.set('sort', sort.property + "," + sort.direction);
        }
        var options = new http_1.RequestOptions({
            search: params
        });
        return this.http.get(webServiceEndpoint + "/plazaPropia", options).map(this.extractData).publish().refCount();
    };
    PlazaPropiaService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], PlazaPropiaService);
    return PlazaPropiaService;
}());
exports.PlazaPropiaService = PlazaPropiaService;
//# sourceMappingURL=plaza-propia.service.js.map