import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {User} from "./model/user.model";


@Injectable({providedIn: 'root'})
export class AuthenticationService {

  public currentUser: Observable<User>;
  user: User;
  logged: boolean;
  admin: boolean;

  constructor(private http: HttpClient) {
    let user = JSON.parse(localStorage.getItem('currentUser'));
    if (user) {
      console.log('Logged user');
      this.setCurrentUser(user);
    }
  }

  private setCurrentUser(user: User) {
    this.logged = true;
    console.log(this.logged, " is logged")
    this.user = user;
    console.log(user, " user")
    // this.admin = user.roles.indexOf('ROLE_ADMIN') !== -1;
    console.log(this.admin, " is admin")
  }

  removeCurrentUser() {
    localStorage.removeItem('currentUser');
    this.logged = false;
    this.admin = false;
  }

  login(user: string, pass: string) {

    let auth = window.btoa(user + ':' + pass);

    const headers = new HttpHeaders({
      Authorization: 'Basic ' + auth,
      'X-Requested-With': 'XMLHttpRequest',
    });

    return this.http.get<User>('/api/logIn', {headers})
      .pipe(map(user => {

        if (user) {
          console.log(user);
          this.user = user;
          this.logged = true;
          user.authdata = auth;
          localStorage.setItem('currentUser', JSON.stringify(user));
        }
        return user;
      }));
  }

  logout() {
    this.removeCurrentUser();
  }
}