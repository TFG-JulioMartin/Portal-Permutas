import { Injectable, NgZone } from '@angular/core';
import { GoogleMapsAPIWrapper } from 'angular2-google-maps/core';
import { MapsAPILoader } from 'angular2-google-maps/core';
import { Observer } from 'rxjs/Observer';
import { Observable } from 'rxjs/Observable';

declare var google: any;

@Injectable()
export class GeocodingService extends GoogleMapsAPIWrapper{
	
    constructor(private __loader: MapsAPILoader, private __zone: NgZone) {
        super(__loader, __zone);
        this.__loader.load().then(() => {
    	console.log('google script loaded');
    	var geocoder = new google.maps.Geocoder();
});     
    }
    
    codeAddress(address: string): Observable<google.maps.GeocoderResult[]> {

        return new Observable((observer: Observer<google.maps.GeocoderResult[]>) => {

            // Invokes geocode method of Google Maps API geocoding.
            this.geocoder.geocode({ 'address': address }, (

                // Results & status.
                (results: google.maps.GeocoderResult[], status: google.maps.GeocoderStatus) => {

                    if (status === google.maps.GeocoderStatus.OK) {

                        observer.next(results);
                        observer.complete();

                    } else {

                        console.log('Geocoding service: geocode was not successful for the following reason: ' + status);

                        observer.error(status);

                    }

                })

            );

        });

    }
}