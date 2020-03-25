import {Component} from "@angular/core";
import {User} from "../model/user.model";
import {Note} from "../model/note.model";

@Component({
  selector: 'app-root',
  templateUrl: '../html/profile.component.html',
})
export class ProfileComponent {
  user:User;
  notes: Note[];
}
