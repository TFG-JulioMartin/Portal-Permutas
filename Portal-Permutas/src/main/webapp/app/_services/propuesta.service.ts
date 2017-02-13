import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Coincidencia, Propuesta } from '../domain';

@Injectable()
export class PropuestaService { 

	private headers = new Headers({'Content-Type': 'application/json'});
	
	constructor(private http: Http) {
	}
		
	getPropuesta(): Rx.Observable<Propuesta[]> {
        return this.http.get('/Portal-Permutas/api/propuesta/findOne').map(this.extractData).publish().refCount();
    }
    
    create(propuesta: Propuesta){
    	return this.http.post('/Portal-Permutas/api/propuesta', propuesta).subscribe((response) => {});
    }
    
    private extractData(res: Response) {
        let body = res.json();
        return body || {};
    }   
}