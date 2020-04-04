import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {User} from "../model/user.model";
import {catchError} from "rxjs/operators";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

const BASE_URL = 'api/users';

@Injectable({ providedIn: 'root' })
export class UserService{

  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<User[]>(`${environment.apiUrl}/users`);
  }
  getUsers(): Observable<User[]> {
    return this.httpClient.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User[]>;
  }

  getUser(id: number | string): Observable<User> {
    return this.httpClient.get(BASE_URL + "/" + id).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User>;
  }

  addUser(user: User): Observable<User> {
    return this.httpClient.post(BASE_URL, user).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User>;
  }

  updateUser(user: User): Observable<User> {
    return this.httpClient.put(BASE_URL + "/" + user.id, user).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<User>;
  }

  getRanking(){
    return this.httpClient.get<User[]>(`${environment.apiUrl}/users/ranking`);
  }

  private handleError(error: any) {
    console.error(error);
    return Observable.throw("Server error (" + error.status + "): " + error.text())
  }


}
