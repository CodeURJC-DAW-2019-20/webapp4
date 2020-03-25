import { Component} from '@angular/core';
import {User} from "../model/user.model";

@Component({
  selector: 'signIn',
  templateUrl: '../html/signIn.component.html'
})
export class SignInComponent {

  user: User;

}
