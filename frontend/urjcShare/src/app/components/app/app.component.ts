import {Component, OnInit} from '@angular/core';
import {NgbModal, NgbModalOptions} from '@ng-bootstrap/ng-bootstrap';
import {ModalAdminComponent} from "../modalAdmin/modalAdmin.component";
import {ModalUploadNoteModule} from "../modal-upload-note/modal-upload-note.module";
import {User} from "../../model/user.model";
import {AuthenticationService} from "../../authentication.service";



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: ['#main-view {margin: 5em auto}']
})
export class AppComponent implements OnInit{
  title = 'urjcShare';
  modalOptions: NgbModalOptions;
  constructor(
    private modalService: NgbModal,
    private authenticationService:AuthenticationService
  ){
    this.modalOptions = {
      backdrop:'static',
      backdropClass:'customBackdrop',
      centered: true
    }
  }


  ngOnInit(): void {
  }

  open() {
    this.modalService.open(ModalAdminComponent);
  }
  openUploadNote(){
    this.modalService.open(ModalUploadNoteModule);
  }


}
