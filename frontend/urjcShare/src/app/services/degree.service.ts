import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Degree} from "../model/degree.model";

const BASE_URL = 'api/degrees';

@Injectable({ providedIn: 'root' })
export class DegreeService{

  constructor(private httpClient: HttpClient) { }

  addDegree(degree: Degree): Observable<Degree> {
    return this.httpClient.post(BASE_URL, degree).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Degree>;
  }

  getDegrees(): Observable<Degree[]> {
    return this.httpClient.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Degree[]>;
  }

  getDegreesByName(name: string): Observable<Degree[]> {
    return this.httpClient.get(BASE_URL + "?name=" + name).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Degree[]>;
  }

  private handleError(error: any) {
    console.error(error);
    return Observable.throw("Server error (" + error.status + "): " + error.text())
  }

}
