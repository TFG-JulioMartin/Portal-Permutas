import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../domain';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {

    private loggedIn: boolean = false;

    constructor(private http: Http) {
    }

    login(username: string, password: string) {
        return this.http.post('/Portal-Permutas/j_spring_security_check?username=' + username + '&password=' + password)
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                let user = response.json();
                if (user.nombre) {
                    this.changeLoginStatus(true);
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

            });

    }
    changeLoginStatus(status: boolean) {
        this.loggedIn = status;
    }

    isLoggedIn() {
        return this.loggedIn;
    }
    
    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}