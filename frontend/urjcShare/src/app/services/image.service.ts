
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {User} from "../model/user.model";
import {Note} from "../model/note.model";

const BASE_URL = 'api/';

@Injectable({ providedIn: 'root' })
export class ImageService {

  constructor(private httpClient: HttpClient) {}

  public uploadImage(image: File, idUser: number): Observable<User> {
    const formData: FormData = new FormData();

    formData.append('imageFile', image, image.name);

    return this.httpClient.post(BASE_URL + "/users" + idUser + "/image", formData) as Observable<User>;
  }

  public uploadFile(file: File, idNote: number): Observable<Note> {
    const formData: FormData = new FormData();

    formData.append('file', file, file.name);

    return this.httpClient.put(BASE_URL + "/notes/" + idNote + "/file", formData) as Observable<Note>;
  }
}
