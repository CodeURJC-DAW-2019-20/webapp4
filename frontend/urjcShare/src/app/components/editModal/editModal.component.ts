import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {User} from "../../model/user.model";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../authentication.service";
import {ImageService} from "../../services/image.service";
import {NgxSpinnerService} from "ngx-spinner";
import {HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-edit-modal',
  templateUrl: './editModal.component.html'
})
export class EditModalComponent implements OnInit {
  @Output() clickevent = new EventEmitter<boolean>();
  user: User;
  imageUser: File;
  newImage: any;

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

  editUser(userForm:User) {
    let auth = window.btoa(userForm.nickname + ':' + userForm.passwordHash);
    if (this.user.passwordHash == null) {
      alert("Escriba una contraseña por favor.");
    } else {
      this.spinner.show();
      this.userService.updateUser(userForm,this.authenticationService.updateHeaders(userForm,auth)).subscribe(
        newUser => {
          if (this.imageUser != null) {
            this.imageService.uploadImage(this.imageUser, userForm.id).subscribe(
              image => {},
              error => console.error("Error al guardar la imagen: " + error));
          }
          this.spinner.hide();
          this.authenticationService.setUser(newUser,auth);
          this.clickevent.emit(true);
          this.activeModal.close();
          alert("El perfil se ha modificado correctamente.")
        },
        error => console.error('Error creating new user: ' + error)
      );
    }

  }

  changeFile(event) {
    this.imageUser = event.target.files[0];
  }
}
