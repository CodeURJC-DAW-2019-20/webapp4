import { Component} from '@angular/core';
import {User} from "../model/user.model";

@Component({
  selector: 'signUp',
  templateUrl: '../html/signUp.component.html'
})
export class SignUpComponent {


  user: User;

}
