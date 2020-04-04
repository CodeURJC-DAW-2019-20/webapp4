import { Component} from '@angular/core';
import {User} from "../../model/user.model";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";

@Component({
  selector:'ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.css']
})
export class RankingComponent {

  user: User;
  usersLoaded:boolean;
  sortedUsers: User[];

  constructor(
    private router: Router,
    private userService: UserService
  ){}

  ngOnInit() {
    this.userService.getRanking().subscribe(users => {
        this.usersLoaded = true;
        this.sortedUsers = users
      },
      error => {
        this.usersLoaded = true;
        console.error("Error al cargar el ranking: " + error)
      });
  }


}
