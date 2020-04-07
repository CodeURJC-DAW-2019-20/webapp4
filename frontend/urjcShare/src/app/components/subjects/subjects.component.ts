import {Component, OnInit} from '@angular/core';
import {SubjectService} from "../../services/subject.service";
import {Subject} from "../../model/subject.model";
import {ActivatedRoute, Router} from "@angular/router";
import {DegreeService} from "../../services/degree.service";
import {Degree} from "../../model/degree.model";
import {NgxSpinnerService} from "ngx-spinner";


@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styles: []
})
export class SubjectsComponent {
  previousComponent: string;
  textSearched: string;
  subjects: Subject[];
  subjectLoaded: boolean;
  subject: Subject;
  degree: Degree;
  page: number = 0;
  size:number = 10;
  lastPageLoaded: boolean;

  constructor(private subjectService: SubjectService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private degreeService: DegreeService,
              private spinner: NgxSpinnerService) {
  }

  ngOnInit() {
    this.subjectLoaded = false;
    this.textSearched = this.activatedRoute.snapshot.queryParams['textSearched'];
    this.previousComponent = this.activatedRoute.snapshot.queryParams['previousComponent'];
    if (this.previousComponent == 'index') {
      this.subjectService.getSubjectByName(this.textSearched).subscribe(
        subject => {
          this.subjectLoaded = true;
          this.subjects = subject
        },
        error => {
          this.subjectLoaded = true;
          console.error("Error al cargar la asignatura bucada:" + error)
        }
      )
    } else {
      this.degreeService.getDegreesByName(this.textSearched).subscribe(
        degrees => {
          this.degree = degrees[0];
          this.subjectService.getSubjectByDegreeIdPaged(this.degree.id, this.page, this.size).subscribe(
            subjects => {
              this.subjects = subjects;
              this.subjectLoaded = true;
              this.page++;
              this.checkIfLastPage();
            },
            error => {
              console.error("Error al cargar la asignatura" + error)
            }
          );
        },
        error => {
          console.error("Error al cargar el grado" + error)
        }
      )
    }


  }

  loadSubjects() {
    this.spinner.show().then(

    );
    this.subjectService.getSubjectByDegreeIdPaged(this.degree.id, this.page, this.size).subscribe(
      subjects => {
        this.subjects = this.subjects.concat(subjects);
        this.page++;
        this.checkIfLastPage();
        this.spinner.hide();
      }
    );
  }

  checkIfLastPage(){
    this.subjectService.getSubjectByDegreeIdPaged(this.degree.id, this.page, this.size).subscribe(
      subjects => {
        this.lastPageLoaded = subjects == null;
      }
    );
  }
}
