import { Component} from '@angular/core';
import {Degree} from "../model/degree.model";

@Component({
  selector: 'degreeList',
  templateUrl: '../html/degree-list.component.html'
})
export class DegreeListComponent {

    degreeSearched: string;
    degrees: Degree[];
}
