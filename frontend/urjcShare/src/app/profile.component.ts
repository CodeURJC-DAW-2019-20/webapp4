import {Component} from "@angular/core";
import {User} from "./user.model";
import {Note} from "./note.model";

@Component({
  selector: 'app-root',
  templateUrl: './profile.component.html',
})
export class ProfileComponent {
  user:User;
  notes: Note[];
}
