import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {User} from "./model/user.model";
import {Observable} from "rxjs";


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
    this.user = user;
    this.admin = user.roles.filter( aux => aux === 'ROLE_ADMIN').length > 0
  }

  removeCurrentUser() {
    localStorage.removeItem('currentUser');
    this.logged = false;
    this.admin = false;
  }
  getUser():User{
    if(localStorage.getItem('currentUser')){
      this.user = JSON.parse(localStorage.getItem('currentUser'));
    }else{
      this.user = null;
    }
    return this.user;
  }
  setUser(user:User, auth:any){
    this.removeCurrentUser();
    user.authdata = auth;
    localStorage.setItem('currentUser', JSON.stringify(user));
    this.setCurrentUser(user);
  }
  updateHeaders(user:User, auth:any):HttpHeaders{
    return new HttpHeaders({
      Authorization: 'Basic ' + auth,
      'X-Requested-With': 'XMLHttpRequest',
    });
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
          this.setUser(user,auth);
        }
        return user;
      }));
  }
  logOut() {

    return this.http.get( '/api/logOut');
  }
  isAdmin() {
    return this.admin
  }
}
