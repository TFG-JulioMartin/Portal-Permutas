import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AlertService } from '../_services/index';
import { PlazaService } from '../listadoPlazas/plaza.service';
import { PlazaPropia } from '../domain';

@Component({
    moduleId: module.id,
    templateUrl: 'editar-plaza.component.html'
})

export class EditarPlazaComponent {
    model: any = {};
    loading = false;
    plaza: PlazaPropia;
    

    constructor(private router: Router, private plazaService: PlazaService, private alertService: AlertService) { 
    	this.getPlaza();
    }
    
    getPlaza(): void {
    	this.plazaService.getPrincipal().subscribe(plaza => this.plaza = plaza);
  	}

    editar() {
        this.loading = true;
        this.plazaService.update(this.plaza)
            .subscribe(
                data => {
                    this.alertService.success('Cambios realizados', true);
                    this.router.navigate(['/home']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}