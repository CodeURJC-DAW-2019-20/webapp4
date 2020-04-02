import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Note} from "../model/note.model";



const BASE_URL = 'api/notes/';

@Injectable({ providedIn: 'root' })
export class NotesService{

  constructor(private httpClient: HttpClient) { }

  addNote(note: Note): Observable<Note> {
    return this.httpClient.post(BASE_URL, note).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Note>;
  }

  getNote(): Observable<Note[]> {
    return this.httpClient.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Note[]>;
  }



  private handleError(error: any) {
    console.error(error);
    return Observable.throw("Server error (" + error.status + "): " + error.text())
  }

}
