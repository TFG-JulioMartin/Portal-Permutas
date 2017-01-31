import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../domain';
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {
    
    constructor(private http: Http) { 
    }

    login(username: string, password: string) {
        return this.http.post('/Portal-Permutas/j_spring_security_check?username=' + username + '&password=' + password)
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                console.log(response);
                let myuser = response.json(); 
                if (myuser && myuser.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(myuser));
                }
                
            });
            
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}