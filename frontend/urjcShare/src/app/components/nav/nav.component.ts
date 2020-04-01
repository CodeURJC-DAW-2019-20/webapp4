import { Component, OnInit } from '@angular/core';
import {ModalAdminComponent} from "../modalAdmin/modalAdmin.component";
import {NgbModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";
import {ModalUploadNoteModule} from "../modal-upload-note/modal-upload-note.module";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  private modalOptions: NgbModalOptions;
  isLogin: boolean;

  constructor(    private modalService: NgbModal) {
    this.modalOptions = {
      backdrop:'static',
      backdropClass:'customBackdrop',
      centered: true
    }
    this.isLogin = false
  }

  ngOnInit(): void {
  }

  openAdmin() {
    this.modalService.open(ModalAdminComponent);

  }
  openUploadNote() {
    this.modalService.open(ModalUploadNoteModule);

  }
}
