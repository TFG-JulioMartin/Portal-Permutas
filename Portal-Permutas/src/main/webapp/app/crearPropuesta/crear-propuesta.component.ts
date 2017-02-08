import { Component , Input } from '@angular/core';
import { Router } from '@angular/router';

import { AlertService, PropuestaService } from '../_services/index';
import { Propuesta } from '../_models/index';
import { ZonaDeseadaComponent }	from '../zonasDeseadas/zona-deseada.component';

@Component({
    moduleId: module.id,
    templateUrl: 'crear-propuesta.component.html'
})

export class CrearPropuestaComponent {
    model: any = {};
    loading = false;
    id: string;

    constructor(private router: Router, private propuestaService: PropuestaService, private alertService: AlertService, private zonaDeseadaComponent : ZonaDeseadaComponent) {
    	this.setId(this.id);
   		console.log(this.zonaDeseadaComponent.getIdDestino());
    }
  
    setId(id: string): void {
    	id = this.zonaDeseadaComponent.getIdDestino();
  	}
    
    getPropuesta(): void {
    	this.propuestaService.getPropuesta().subscribe(propuesta => this.propuesta = propuesta);
  	}

    crearPropuesta() {
        this.loading = true;
        this.userService.update(this.principal)
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', true);
                    this.router.navigate(['/home']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}