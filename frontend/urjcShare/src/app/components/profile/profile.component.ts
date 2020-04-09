import {Component, OnInit} from "@angular/core";
import {User} from "../../model/user.model";
import {Note} from "../../model/note.model";
import {EditModalComponent} from "../editModal/editModal.component";
import {NgbModal, NgbModalOptions} from "@ng-bootstrap/ng-bootstrap";
import {AuthenticationService} from "../../authentication.service";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";
import {environment} from "../../../environments/environment";
import {GraphComponent} from "../graph/graph.component";
import {NotesService} from "../../services/notes.service";

@Component({
  selector: 'profile',
  templateUrl: './profile.component.html',
  styles: ['.btn { margin-bottom:auto }']
})
export class ProfileComponent implements OnInit {
  user: User;
  notes: Note[];
  newImage: any;
  modalOptions: NgbModalOptions;
  graph: GraphComponent

  constructor(
    private router: Router,
    private modalService: NgbModal,
    private authenticationService: AuthenticationService,
    private userService: UserService,
  ) {
    this.modalOptions = {
      backdrop: 'static',
      backdropClass: 'customBackdrop'
    }

  }

  goToNote(idNote: number) {
    this.router.navigateByUrl("note/" + idNote);
  }

  refreshUser() {
    this.newImage = new Date().getTime();
    this.user = this.authenticationService.getUser();
  }

  open() {
    const modalRef = this.modalService.open(EditModalComponent);
    modalRef.componentInstance.clickevent.subscribe((wfsd: boolean) => {
      this.refreshUser();
    })
  }

  ngOnInit(): void {
    this.newImage = new Date().getTime();
    if (this.authenticationService.logged) {
      this.user = this.authenticationService.getUser();
      this.userService.getUser(this.user.id).subscribe(
        user => {
          this.notes = user.notes;
        }
      )
    }
  }

}

