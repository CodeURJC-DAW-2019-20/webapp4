import {Component, OnInit} from '@angular/core';
import {Degree} from "../../model/degree.model";
import {ActivatedRoute, Router} from '@angular/router';
import {DegreeService} from "../../services/degree.service";

@Component({
  selector: 'degreeList',
  templateUrl: './degree-list.component.html'
})
export class DegreeListComponent implements OnInit {

  degreeSearched: string;
  degrees: Degree[];
  //To prevent the empty list message from appearing before the degrees are back from the backend
  degreesLoaded: boolean;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private degreeService: DegreeService) {
  }

  ngOnInit() {
    this.degreesLoaded = false;
    this.degreeSearched = this.activatedRoute.snapshot.queryParams['textSearched'];
    this.degreeService.getDegreesByName(this.degreeSearched).subscribe(
      degrees => {
        this.degreesLoaded = true;
        this.degrees = degrees
      },
      error => {
        this.degreesLoaded = true;
        console.error("Error al cargar el grado buscado: " + error)
      }
    )
  }


}
