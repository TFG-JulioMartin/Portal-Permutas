import {
  Component,
  OnInit
} from '@angular/core';

import {PlazaService} from './listadoPlazas/plaza.service';
import {GeocodingService} from './_services/index';
import {PlazaPropia} from './listadoPlazas/plazaPropia';
import {Router} from '@angular/router';


@Component({
  moduleId:	module.id,
  selector: 'g-map',
  styles: [`
    .sebm-google-map-container {
       height: 600px;
     }
  `],
  templateUrl: 'map.component.html'
})

export class MapComponent implements OnInit{
  // google maps zoom level

	plazas: PlazaPropia[];
	markers2: marker[];
	address = 'Plaza Vicente Aleixandre, Sevilla';
	
    constructor(private plazaService: PlazaService, private geocodingService: GeocodingService, private router: Router) {
	}  
	ngOnInit(){
		this.getPlazas();
		this.getCoords();
	}
  zoom: number = 13;
  
	getPlazas(): void {
    	this.plazaService.getPlazas().subscribe(plazas => this.plazas = plazas);
	}
	
	getCoords(): void {
		this.geocodingService.codeAddress(this.address);
	}
	
  
  // initial center position for the map
  lat: number = 37.362444;
  lng: number = -5.9965;
  
  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`)
  }
  
  mapClicked($event: MouseEvent) {
    this.markers.push({
      lat: $event.coords.lat,
      lng: $event.coords.lng
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