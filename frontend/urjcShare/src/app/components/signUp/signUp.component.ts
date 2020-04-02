import {Component, OnInit} from '@angular/core';
import {User} from "../../model/user.model";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {ImageService} from "../../services/image.service";
import {NgxSpinnerService} from "ngx-spinner";

@Component({
  selector: 'signUp',
  templateUrl: './signUp.component.html'
})
export class SignUpComponent implements OnInit {

  user: User;
  imageUser: File;

  constructor(private userService: UserService, private imageService: ImageService, private router: Router, private spinner: NgxSpinnerService) {
  }

  ngOnInit(): void {
    this.user = {
      name: '',
      passwordHash: '',
      degree: '',
      nickname: '',
      email: '',
      number: '',
      notes: [],
      roles: ["ROLE_USER"],
      scores: [],
      media: 0,
      image: false,
    };
  }

  save() {
    this.spinner.show();
    this.userService.addUser(this.user).subscribe(
      user => {
        this.imageService.uploadImage(this.imageUser, user.id).subscribe(
          user => {
            this.spinner.hide();
            this.router.navigate(['/']);
          },
          error => console.error("Error al guardar la imagen: " + error)
        )
      },
      error => {
        this.spinner.hide();
        console.error("Error al crear el usuario: " + error)
      }
    );
  }

  changeFile(files: FileList) {
    this.imageUser = files.item(0);
  }

}
