import { Component } from '@angular/core';
import {Router} from '@angular/router';

import {ZonaDeseadaService} from './zona-deseada.service';
import {PlazaService} from '../listadoPlazas/plaza.service';
import {ZonaDeseada, Coincidencia} from '../domain';
import {Table} from '../table';


@Component({
  moduleId:	module.id,
  selector: 'g-map',
  styles: [`
    .sebm-google-map-container {
       height: 600px;
     }
  `],
  templateUrl: 'zona-deseada.component.html'
})

export class ZonaDeseadaComponent implements Table<PlazaPropia>{
  // google maps zoom level
  
	zonas: ZonaDeseada[];
	plazas: PlazaPropia[]; 
	coincidencias : Coincidencia[];
	idDestino: string;
	model: any = {};
	slat: number;
	slng: number;
	elat: number;
	elng: number;
	
	constructor(private zonaDeseadaService: ZonaDeseadaService, private plazaService: PlazaService, private router: Router) {
		this.getCoincidencias();
		this.getPlazas();
		this.getZonas();
    }
    
    getPlazas(): void {
    	this.plazaService.getPlazas().subscribe(plazas => this.plazas = plazas);
	}
    
    getZonas(): void {
    	this.zonaDeseadaService.getZonas().subscribe(zonas => this.zonas = zonas);
  	}
  	
  	getCoincidencias(): void {
    	this.zonaDeseadaService.checkCoincidencias().subscribe(coincidencias => this.coincidencias = coincidencias);
  	}
  		
  	proponer(id : string) : void {
  		this.idDestino=id;
  		this.router.navigate(['/crearPropuesta', id]);
  	}
  	
  zoom: number = 13;
  
  // initial center position for the map
  lat: number = 37.362444;
  lng: number = -5.9965;
  
  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`)
  }
  
	mapClicked($event: MouseEvent) {
		this.slat = $event.coords.lat;
		this.slng = $event.coords.lng; 
  	}
  
	mapRightCliked($event: MouseEvent) {
    	this.elat = $event.coords.lat;
		this.elng = $event.coords.lng;
		this.model.slat=this.slat;
		this.model.slng=this.slng;
		this.model.elat=this.elat;
		this.model.elng=this.elng;	
		this.zonaDeseadaService.createZone(this.model);
  	}
  	
  	createZone() {
        this.zonaDeseadaService.createZone(this.slat)
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
  
  markerDragEnd(m: marker, $event: MouseEvent) {
    console.log('dragEnd', m, $event);
  }
  
  markers: marker[] = [
	  {
		  lat: 37.382444,
		  lng: -5.99625,
		  label: 'A',
		  draggable: true
	  },
	  {
		  lat: 	37.3541545,
		  lng: -5.9885772,
		  label: 'A',
		  draggable: true
	  }
  ]
}
// just an interface for type safety.
interface marker {
	lat: number;
	lng: number;
	label?: string;
	draggable: boolean;
}