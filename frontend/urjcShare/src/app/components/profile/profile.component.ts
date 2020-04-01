import {Component} from "@angular/core";
import {User} from "../../model/user.model";
import {Note} from "../../model/note.model";
import {EditModalComponent} from "../editModal/editModal.component";
import {NgbModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";
import {AuthenticationService} from "../../authentication.service";

@Component({
  selector: 'profile',
  templateUrl: './profile.component.html',
  styles: ['.btn { margin-bottom:auto }']
})
export class ProfileComponent {
  user:User;
  notes: Note[];

  modalOptions:NgbModalOptions;

  constructor(
    private modalService: NgbModal,
    private authenticationService: AuthenticationService
  ){
    this.user=this.authenticationService.getUser();
    this.modalOptions = {
      backdrop:'static',
      backdropClass:'customBackdrop'
    }
  }

  open() {
    this.modalService.open(EditModalComponent);
  }
}

