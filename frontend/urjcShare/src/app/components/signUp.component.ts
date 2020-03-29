import {Component, OnInit} from '@angular/core';
import {User} from "../model/user.model";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'signUp',
  templateUrl: '../html/signUp.component.html'
})
export class SignUpComponent implements OnInit{

  user: User;

  constructor(private userService: UserService, private router:Router) {}

  ngOnInit(): void {
    this.user = {
      name: '',
      passwordHash: '',
      degree: ' ',
      nickname: ' ',
      email: ' ',
      number: ' ',
      roles: ["ROLE_USER"]};
  }

  save() {
    this.userService.addUser(this.user).subscribe(
      book => { },
      error => console.error('Error creating new user: ' + error)
    );
    this.router.navigate(['/']);
  }
}
