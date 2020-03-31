
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {User} from "../model/user.model";

const BASE_URL = 'api/users';

@Injectable({ providedIn: 'root' })
export class ImageService {

  constructor(private httpClient: HttpClient) {}

  public uploadImage(image: File, idUser: number): Observable<User> {
    const formData: FormData = new FormData();

    formData.append('imageFile', image, image.name);

    return this.httpClient.post(BASE_URL + "/" + idUser + "/image", formData) as Observable<User>;
  }
}
