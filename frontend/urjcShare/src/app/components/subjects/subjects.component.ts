import { Component, OnInit } from '@angular/core';
import {Subject} from "rxjs";

@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styles: []
})
export class SubjectsComponent  {

  subject:Subject<any>;

}
