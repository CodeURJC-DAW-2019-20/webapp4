import { Component} from '@angular/core';
import {Degree} from "../model/degree.model";

@Component({
  selector:'ranking',
  templateUrl: '../html/ranking.component.html',
  styleUrls: ['../css/ranking.component.css']
})
export class RankingComponent {

  name: string;
  media: number;
}
