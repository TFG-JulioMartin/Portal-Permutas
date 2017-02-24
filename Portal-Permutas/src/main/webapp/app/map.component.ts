import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import { PlazaService, AuthenticationService } from './_services/index';
import { PlazaPropia } from './listadoPlazas/plazaPropia';


@Component({
    moduleId: module.id,
    selector: 'g-map',
    styles: [`
    .sebm-google-map-container {
       height: 600px;
     }
  `],
    templateUrl: 'map.component.html'
})

export class MapComponent implements OnInit {

    // google maps zoom level  
    zoom: number = 13;
    
    // initial center position for the map
    lat: number = 37.362444;
    lng: number = -5.9965;

    plazas: PlazaPropia[];

    constructor(private plazaService: PlazaService , private router: Router, private authenticationService: AuthenticationService) {
        
    }
    ngOnInit() {
        this.getPlazas();
    }

    getPlazas(): void {
        this.plazaService.getPlazas().subscribe(plazas => this.plazas = plazas);
    }
    
    proponer(id : string) : void {
  		this.router.navigate(['/crearPropuesta', id]);
  	}

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
            lat: 37.3541545,
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