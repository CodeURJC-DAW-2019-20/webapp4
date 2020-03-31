import { Component} from '@angular/core';
import {Degree} from "../../model/degree.model";

@Component({
  selector:'ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.css']
})
export class RankingComponent {

  name: string;
  media: number;
}
