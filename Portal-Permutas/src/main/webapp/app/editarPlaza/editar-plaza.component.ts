import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AlertService, PlazaService } from '../_services/index';
import { PlazaPropia } from '../domain';

@Component({
    moduleId: module.id,
    templateUrl: 'editar-plaza.component.html'
})

export class EditarPlazaComponent {
    model: any = {};
    loading = false;
    plaza: PlazaPropia;
    color = 'primary';
  	mode = 'determinate';
  	value = 50;
    

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