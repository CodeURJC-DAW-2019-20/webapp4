import { Component} from '@angular/core';
import {User} from "./user.model";

@Component({
  selector: 'signUp',
  templateUrl: './signUp.component.html'
})
export class SignUpComponent {


  user: User;

}
