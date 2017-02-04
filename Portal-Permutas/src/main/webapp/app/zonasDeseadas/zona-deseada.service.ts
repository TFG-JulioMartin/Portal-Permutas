import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { ZonaDeseadaDTO } from '../domain';

@Injectable()
export class ZonaDeseadaService { 

	private headers = new Headers({'Content-Type': 'application/json'});
	
	constructor(private http: Http) {
	}
		
	getZonas(): Rx.Observable<PlazaPropia[]> {
        return this.http.get('/Portal-Permutas/api/zonaDeseada/all').map(this.extractData).publish().refCount();
    }
    
    createZone(zona: ZonaDeseadaDTO) {
    	console.log(zona);
    	return this.http.post('/Portal-Permutas/api/zonaDeseada', zona).subscribe((response) => {});
    }
    
    private extractData(res: Response) {
        let body = res.json();
        return body || {};
    }   
}