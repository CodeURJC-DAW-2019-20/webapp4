import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {catchError} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Note} from "../model/note.model";


const BASE_URL = 'api/notes/';
const BASE_URL_SUB = 'api/subjects/';

@Injectable({providedIn: 'root'})
export class NotesService {

  constructor(private httpClient: HttpClient) {
  }

  addNote(note: Note): Observable<Note> {
    return this.httpClient.post(BASE_URL, note).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Note>;
  }

  getNotes(): Observable<Note[]> {
    return this.httpClient.get(BASE_URL).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Note[]>;
  }
  getNoteByID(id :any): Observable<Note[]> {
    return this.httpClient.get(BASE_URL + id).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Note[]>;
  }

  getNotesBySubject(id: any): Observable<Note[]> {
    return this.httpClient.get(BASE_URL_SUB + id + '/allNotes').pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Note[]>;
  }

  getNotesBySubjectPaged(id: any, page: number, size: number): Observable<Note[]> {
    return this.httpClient.get(BASE_URL_SUB + id + '/notes?page=' + page + '&size=' + size).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<Note[]>;
  }

  voteNote(id: any, currentRate: any): Observable<any> {
    return this.httpClient.post(BASE_URL + id + '/scores',{score:currentRate}).pipe(
      catchError(error => this.handleError(error))
    ) as Observable<any>;
  }

  private handleError(error: any) {
    console.error(error);
    return Observable.throw("Server error (" + error.status + "): " + error.text())
  }


}
