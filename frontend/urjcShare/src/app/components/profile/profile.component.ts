import {Component, OnInit} from "@angular/core";
import {User} from "../../model/user.model";
import {Note} from "../../model/note.model";
import {EditModalComponent} from "../editModal/editModal.component";
import {NgbModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";
import {AuthenticationService} from "../../authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'profile',
  templateUrl: './profile.component.html',
  styles: ['.btn { margin-bottom:auto }']
})
export class ProfileComponent implements OnInit{
  user: User;
  notes: Note[];
  newImage: any;
  modalOptions: NgbModalOptions;

  constructor(
    private router: Router,
    private modalService: NgbModal,
    private authenticationService: AuthenticationService
  ) {
    this.modalOptions = {
      backdrop: 'static',
      backdropClass: 'customBackdrop'
    }

  }

  refreshUser() {
    this.newImage = new Date().getTime();
    this.user = this.authenticationService.getUser();
  }

  open() {
    const modalRef = this.modalService.open(EditModalComponent);
    modalRef.componentInstance.clickevent.subscribe((wfsd: boolean) => {
      console.log(wfsd)
      this.refreshUser();
    })
  }

  ngOnInit(): void {
    this.newImage = new Date().getTime();
    this.user = this.authenticationService.getUser();
  }

}

