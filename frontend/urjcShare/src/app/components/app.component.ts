import { Component } from '@angular/core';
import {NgbModal, NgbModalOptions} from '@ng-bootstrap/ng-bootstrap';
import {ModalAdminComponent} from "./modalAdmin.component";

@Component({
  selector: 'app-root',
  templateUrl: '../html/app.component.html',
  styles: ['#main-view {margin-top: 5em}']
})
export class AppComponent {
  title = 'urjcShare';
  modalOptions: NgbModalOptions;

  constructor(
    private modalService: NgbModal
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


}
