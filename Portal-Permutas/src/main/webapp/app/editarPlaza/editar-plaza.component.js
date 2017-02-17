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
var EditarPlazaComponent = (function () {
    function EditarPlazaComponent(router, plazaService, alertService) {
        this.router = router;
        this.plazaService = plazaService;
        this.alertService = alertService;
        this.model = {};
        this.loading = false;
        this.color = 'primary';
        this.mode = 'determinate';
        this.value = 50;
        this.getPlaza();
    }
    EditarPlazaComponent.prototype.getPlaza = function () {
        var _this = this;
        this.plazaService.getPrincipal().subscribe(function (plaza) { return _this.plaza = plaza; });
    };
    EditarPlazaComponent.prototype.editar = function () {
        var _this = this;
        this.loading = true;
        this.plazaService.update(this.plaza)
            .subscribe(function (data) {
            _this.alertService.success('Cambios realizados', true);
            _this.router.navigate(['/home']);
        }, function (error) {
            _this.alertService.error(error);
            _this.loading = false;
        });
    };
    EditarPlazaComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            templateUrl: 'editar-plaza.component.html'
        }), 
        __metadata('design:paramtypes', [router_1.Router, index_1.PlazaService, index_1.AlertService])
    ], EditarPlazaComponent);
    return EditarPlazaComponent;
}());
exports.EditarPlazaComponent = EditarPlazaComponent;
//# sourceMappingURL=editar-plaza.component.js.map