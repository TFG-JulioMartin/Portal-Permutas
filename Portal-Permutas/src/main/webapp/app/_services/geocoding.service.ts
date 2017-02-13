import { Injectable, NgZone } from '@angular/core';
import { GoogleMapsAPIWrapper } from 'angular2-google-maps/core';
import { MapsAPILoader } from 'angular2-google-maps/core';
import { Observer } from 'rxjs/Observer';
import { Observable } from 'rxjs/Observable';

declare var google: any;

@Injectable()
export class GeocodingService extends GoogleMapsAPIWrapper{
	
    cargado: boolean;
	
    constructor(private __loader: MapsAPILoader, private __zone: NgZone) {
    	super(__loader, __zone);
        this.cargado=false;
    	this.__loader.load().then(() => {
    		console.log('google script loaded');    		
    		//console.log(this.geocoder);
            this.cargado=true;
    	});
    }
    
    getLatLan(address: string):  Observable<google.maps.GeocoderResult> {    	
                
        return new Observable((observer: Observer<google.maps.GeocoderResult>) => {                            
            if(this.cargado){
            (new google.maps.Geocoder()).geocode({ 'address': address }, (
                (results: google.maps.GeocoderResult[], status: google.maps.GeocoderStatus) => {
                    if (status === google.maps.GeocoderStatus.OK) {
                        var i;
                        console.log(results.length);
                        for(i=0;i<results.length;i++){                            
                            console.log(results[i]);
                            observer.next(results[i]);
                        }
                        observer.complete();
                    } else {
                        console.log('ERROR> Geocoding service: geocode was not successful for the following reason: ' + status);
                        observer.complete();
                    }
                })
            );
            }
            if(observer)                
                observer.complete();
                   
        });
    }
}