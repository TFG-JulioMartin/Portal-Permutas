import {
  Component,
  OnInit
} from '@angular/core';

import {Router} from '@angular/router';

import {ZonaDeseadaService} from './zona-deseada.service';
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

export class ZonaDeseadaComponent implements OnInit, , Table<PlazaPropia>{
  // google maps zoom level
  
	zonas: ZonaDeseada[];
	coincidencias : Coincidencia[];
	model: any = {};
	slat: number;
	slng: number;
	elat: number;
	elng: number;
	
	constructor(private zonaDeseadaService: ZonaDeseadaService, private router: Router) {
    }
	
    ngOnInit() {
        this.getZonas();
        this.getCoincidencias();
    }
    
    getZonas(): void {
    	this.zonaDeseadaService.getZonas().subscribe(zonas => this.zonas = zonas);
  	}
  	
  	getCoincidencias(): void {
    	this.zonaDeseadaService.checkCoincidencias().subscribe(coincidencias => this.coincidencias = coincidencias);
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