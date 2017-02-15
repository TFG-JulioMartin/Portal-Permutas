import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Coincidencia, Propuesta, PropuestaDTO } from '../domain';

@Injectable()
export class PropuestaService { 

	private headers = new Headers({'Content-Type': 'application/json'});
	
	constructor(private http: Http) {
	}
		
	getPropuesta(id : string): Rx.Observable<Propuesta> {
        return this.http.get('/Portal-Permutas/api/propuesta/findOne/' +id).map(this.extractData).publish().refCount();
    }
    
    getPropuestasEnviadas(): Rx.Observable<PropuestaDTO[]> {
        return this.http.get('/Portal-Permutas/api/propuesta/enviadas').map(this.extractData).publish().refCount();
    }
    
    getPropuestasRecibidas(): Rx.Observable<PropuestaDTO[]> {
        return this.http.get('/Portal-Permutas/api/propuesta/recibidas').map(this.extractData).publish().refCount();
    }
    
    create(propuesta: Propuesta){
    	return this.http.post('/Portal-Permutas/api/propuesta', propuesta).subscribe((response) => {});
    }
    
    aceptarPropuesta(id : string){
    	return this.http.put('/Portal-Permutas/api/propuesta/aceptar/' +id).map(res => res.json());   	
    }
    
    rechazarPropuesta(id : string){
    	return this.http.put('/Portal-Permutas/api/propuesta/rechazar/' +id).map(res => res.json()); 	
    }
    
    private extractData(res: Response) {
        let body = res.json();
        return body || {};
    }   
}