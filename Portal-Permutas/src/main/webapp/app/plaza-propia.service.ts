import {Injectable} from '@angular/core';
import {PlazaPropia} from './domain'
import {Http, Response, URLSearchParams, RequestOptions} from '@angular/http';
import * as Rx from "rxjs/Rx";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';


@Injectable()
export class PlazaPropiaService {

    constructor(private http: Http) {

    }

    findPlazas(page: number, pageSize: number, sort: PaginationPropertySort): Rx.Observable<PaginationPage<PlazaPropia>> {
        let params = new URLSearchParams();
        params.set('size', `${pageSize}`);
        params.set('page', `${page}`);
        if (sort != null) {
            params.set('sort', `${sort.property},${sort.direction}`);
        }

        let options = new RequestOptions({
            search: params
        });
        return this.http.get(`${webServiceEndpoint}/plazaPropia`, options).map(this.extractData).publish().refCount();
    }