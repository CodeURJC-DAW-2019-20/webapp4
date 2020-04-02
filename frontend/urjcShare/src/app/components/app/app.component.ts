import { Component } from '@angular/core';
import {NgbModal, NgbModalOptions} from '@ng-bootstrap/ng-bootstrap';
import {ModalAdminComponent} from "../modalAdmin/modalAdmin.component";
import {ModalUploadNoteModule} from "../modal-upload-note/modal-upload-note.module";
import {User} from "../../model/user.model";



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: ['#main-view {margin: 5em auto}']
})
export class AppComponent {
  title = 'urjcShare';
  modalOptions: NgbModalOptions;
  constructor(
    private modalService: NgbModal,
  ){
    this.modalOptions = {
      backdrop:'static',
      backdropClass:'customBackdrop',
      centered: true
    }
  }

  open() {
    this.modalService.open(ModalAdminComponent);
  }

  openUploadNote(){
    this.modalService.open(ModalUploadNoteModule);
  }


}
