import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Observable} from "rxjs";
import {Subject} from "../model/subject.model";

const BASE_URL = 'api/subjects';

@Injectable({ providedIn: 'root' })
export class SubjectService{

  constructor(private httpClient: HttpClient) { }

  getSubjectByDegreeId(id: number | string){
    return this.httpClient.get('api/degrees/' + id + '/subjects').pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Subject[]>;
  }




  private handleError(error: any) {
    console.error(error);
    return Observable.throw("Server error (" + error.status + "): " + error.text())
  }
}
