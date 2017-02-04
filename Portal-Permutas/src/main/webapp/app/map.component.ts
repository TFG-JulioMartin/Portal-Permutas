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
	arr;
	newArr = [];
	
    constructor(private plazaService: PlazaService, private geocodingService: GeocodingService, private router: Router) {
    	this.arr = [ {address: 'Plaza Vicente Aleixandre, Sevilla'}, {address: 'Calle Colombia, Sevilla'}]
    	// this.getLanLon();
	}  
	ngOnInit(){
		this.getPlazas();
	}
  zoom: number = 13;
  
	getPlazas(): void {
    	this.plazaService.getPlazas().subscribe(plazas => this.plazas = plazas);
	}
		
	getLanLon() {
    	this.arr.forEach(x => {
        	this.geocodingService.getLatLan(x.address).subscribe(data => {
          		let lati = data.results[0].geometry.location.lat;
          		let long = data.results[0].geometry.location.lng;
          		let newObj = Object.assign({}, {address: x.address, lat: lati, lon: long})
          		this.newArr.push(newObj);
        	});    
    	})
  	}


	
  // initial center position for the map
  lat: number = 37.362444;
  lng: number = -5.9965;
  
  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`)
  }
  
  addToMarkers(
  
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