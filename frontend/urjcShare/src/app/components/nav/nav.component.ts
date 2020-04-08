import { Component, OnInit } from '@angular/core';
import {ModalAdminComponent} from "../modalAdmin/modalAdmin.component";
import {NgbModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";
import {ModalUploadNoteModule} from "../modal-upload-note/modal-upload-note.module";
import {AuthenticationService} from "../../authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  private modalOptions: NgbModalOptions;

  constructor(    private modalService: NgbModal, private authenticationService:AuthenticationService,private router:Router) {
    this.modalOptions = {
      backdrop:'static',
      backdropClass:'customBackdrop',
      centered: true
    };
  }

  ngOnInit(): void {
  }
  logout() {
    this.authenticationService.logOut().subscribe(
      (response) => {
        this.authenticationService.removeCurrentUser();
        this.router.navigate(['/']);
      },
      (error) => console.log('Error when trying to log out: ' + error),
    );
  }
  openAdmin() {
    this.modalService.open(ModalAdminComponent);
  }
  openUploadNote() {
    this.modalService.open(ModalUploadNoteModule);

  }
  get loggin() {
    return this.authenticationService.getUser()
  }
  get admin() {
    return this.authenticationService.isAdmin()
  }
}
