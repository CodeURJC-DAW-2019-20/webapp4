import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {User} from "../model/user.model";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit-modal',
  templateUrl: '../html/editModal.component.html'
})
export class EditModalComponent implements OnInit{
  @Input() my_modal_title;
  @Input() my_modal_content;
  user: User;
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
  constructor(private userService: UserService, private router:Router, public activeModal: NgbActiveModal) {}
  editUser(){
    console.log(this.user)//TODO
    this.user.id=28; //This must be currentUser.id tu edit his profile
    this.userService.addUser(this.user).subscribe(
      user => { },
      error => console.error('Error creating new user: ' + error)
    );
    this.router.navigate(['/']);
  }
}
