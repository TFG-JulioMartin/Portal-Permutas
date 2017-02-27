import { Component, NgZone } from '@angular/core';
import { Router } from '@angular/router';

import { PlazaService, ZonaDeseadaService, GeocodingService } from '../_services/index';
import { ZonaDeseada, Coincidencia, PlazaPropia } from '../domain';
import { GoogleMapsAPIWrapper } from 'angular2-google-maps/core';


@Component({
    moduleId: module.id,
    styles: [`
    .sebm-google-map-container {
       height: 600px;
     }
  `],
    templateUrl: 'zona-deseada.component.html'
})

export class ZonaDeseadaComponent implements Table<PlazaPropia>{

    // google maps zoom level
    zoom: number = 13;

    // initial center position for the map
    lat: number = 37.362444;
    lng: number = -5.9965;

    zonas: ZonaDeseada[];
    plazas: PlazaPropia[];
    coincidencias: Coincidencia[];
    address : string;
    desarrollo: boolean = false;

    model: any = {};
    slat: number;
    slng: number;
    elat: number;
    elng: number;

    constructor(
    private zonaDeseadaService: ZonaDeseadaService, 
    private plazaService: PlazaService, 
    private router: Router,
    private geocodingService: GeocodingService,
    private zone: NgZone) {
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

    proponer(id: string): void {
        this.router.navigate(['/crearPropuesta', id]);
    }

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
        this.model.slat = this.slat;
        this.model.slng = this.slng;
        this.model.elat = this.elat;
        this.model.elng = this.elng;
        this.createZone();
    }

    createZone() {
        this.zonaDeseadaService.createZone(this.model).subscribe(
            data => {
                this.getZonas();
                this.getCoincidencias();
            },
            error => {
                console.log(error);
            });
    }

    deleteZone(id: string) {
        let r = confirm('¿Borrar esta zona?');
        if (r == true) {
            this.zonaDeseadaService.deleteZone(id).then(() => {
                this.getZonas();
                this.getCoincidencias();
            });
        }
    }
    
    goToZone(lat: number, lng: number){
        this.lat= lat;
        this.lng = lng;
    }
    
    search(){
        this.geocodingService.getLatLon(this.address).subscribe(
            data => {
                this.zone.run(() => {
                    this.lat = data.lat();
                    this.lng = data.lng();
                    this.zoom = 18;
                }
            },
            error => {
                console.log(error);
            });
    }
    
    keyDownFunction($event) {
        if(event.keyCode == 13) {
        this.geocodingService.getLatLon(this.address).subscribe(
            data => {
                this.zone.run(() => {
                    this.lat = data.lat();
                    this.lng = data.lng();
                    this.zoom = 18;
                }
            },
            error => {
                console.log(error);
            });
         }
    }

}