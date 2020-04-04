import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {User} from "../../model/user.model";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../authentication.service";
import {ImageService} from "../../services/image.service";
import {NgxSpinnerService} from "ngx-spinner";

@Component({
  selector: 'app-edit-modal',
  templateUrl: './editModal.component.html'
})
export class EditModalComponent implements OnInit {
  @Output() clickevent = new EventEmitter<boolean>();
  user: User;
  imageUser: File;

  ngOnInit(): void {
    this.newImage = new Date().getTime();
    this.user = this.authenticationService.getUser();
  }

  constructor(
    private userService: UserService,
    private imageService: ImageService,
    private router: Router,
    private authenticationService: AuthenticationService,
    public activeModal: NgbActiveModal,
    private spinner: NgxSpinnerService) {
  }

  editUser() {
    this.spinner.show();
    this.userService.updateUser(this.user).subscribe(
      user => {
        if (this.imageUser != null) {
          this.imageService.uploadImage(this.imageUser, this.user.id).subscribe(
            image => {},
            error => console.error("Error al guardar la imagen: " + error));
        }
        this.spinner.hide();
        console.log(user);
        this.authenticationService.setUser(user);
        this.clickevent.emit(true);
        this.activeModal.close();
      },
      error => console.error('Error creating new user: ' + error)
    );
  }

  changeFile(event) {
    this.imageUser = event.target.files[0];
  }
}
