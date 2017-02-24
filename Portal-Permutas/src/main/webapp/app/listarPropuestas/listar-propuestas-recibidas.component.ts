import { Component, OnInit } from '@angular/core';
import { Response } from '@angular/http';
import { Router} from '@angular/router';
import * as Rx from 'rxjs/Rx';

import 'rxjs/add/operator/switchMap';

import { PropuestaService, PlazaService } from '../_services/index';
import { Propuesta, PlazaPropia } from '../domain';


@Component({
    moduleId: module.id,
    styles: [`
    .sebm-google-map-container {
       height: 600px;
     }
  `],
    templateUrl: 'listar-propuestas-recibidas.component.html'
    
})
export class ListarPropuestasRecibidasComponent implements OnInit {

    propuestas: Propuesta[];
    msg: string;
    plazaRemitente: PlazaPropia;
    textoPropuesta: string;

    // initial center position for the map
    lat: number = 37.362444;
    lng: number = -5.9965;   
    zoom: number = 13;

    constructor(private propuestaService: PropuestaService, private router: Router, private plazaService: PlazaService) {
    }

    ngOnInit() {
        this.getPropuestasRecibidas();
    }

    getPropuestasRecibidas(): void {
        this.propuestaService.getPropuestasRecibidas().subscribe(propuestas => { this.propuestas = propuestas });
    }

    getPlazaRemitente(id: string, texto: string) {
    	this.textoPropuesta = texto;
        this.plazaService.getPlaza(id).subscribe(plazaRemitente => this.plazaRemitente = plazaRemitente);
    }
    
    cerrar(){
        this.plazaRemitente = null;
    }

    aceptar(id: string) {
        this.propuestaService.aceptarPropuesta(id).subscribe(
            data => {
                this.getPropuestasRecibidas();
            },
            error => {
            	console.log(error);
            });
    }

    rechazar(id: string) {
        this.propuestaService.rechazarPropuesta(id).subscribe(
            data => {
                this.getPropuestasRecibidas();
            },
            error => {
                console.log(error);
            });
    }

    clickedMarker(label: string, index: number) {
        console.log(`clicked the marker: ${label || index}`)
    }

    mapClicked($event: MouseEvent) {
        
    }

    markerDragEnd(m: marker, $event: MouseEvent) {
        console.log('dragEnd', m, $event);
    }

}