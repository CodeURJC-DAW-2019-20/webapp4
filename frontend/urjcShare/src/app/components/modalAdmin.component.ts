import {Component} from "@angular/core";
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'modalAdmin',
  templateUrl: '../html/modalAdmin.component.html',
})
export class ModalAdminComponent {

  constructor(public activeModal: NgbActiveModal) {}
}
