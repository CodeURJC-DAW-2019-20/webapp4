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
  page: number;
  size:number = 10;
  lastPageLoaded: boolean;

  constructor(private subjectService: SubjectService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private degreeService: DegreeService,
              private spinner: NgxSpinnerService) {
  }

  ngOnInit() {
    this.page = 0;
    this.subjectLoaded = false;
    this.textSearched = this.activatedRoute.snapshot.queryParams['textSearched'];
    this.previousComponent = this.activatedRoute.snapshot.queryParams['previousComponent'];

    if (this.previousComponent == 'index') {
      this.subjectService.getSubjectByNamePaged(this.textSearched, this.page, this.size).subscribe(
        subject => {

          this.subjects = subject;
          this.page++;
          this.checkIfLastPageBySubject();
          this.subjectLoaded = true;
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
              this.page++;
              this.checkIfLastPageByDegree();
              this.subjectLoaded = true;
            },
            error => {
              this.subjectLoaded = true;
              console.error("Error al cargar la asignatura" + error);
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
    this.spinner.show();
    if(this.previousComponent == 'index'){
      this.subjectService.getSubjectByNamePaged(this.textSearched, this.page, this.size).subscribe(
        subjects => {
          this.subjects = this.subjects.concat(subjects);
          this.page++;
          this.checkIfLastPageBySubject();
          this.spinner.hide();
        }
      );
    }else{
      this.subjectService.getSubjectByDegreeIdPaged(this.degree.id, this.page, this.size).subscribe(
        subjects => {
          this.subjects = this.subjects.concat(subjects);
          this.page++;
          this.checkIfLastPageByDegree();
          this.spinner.hide();
        }
      );
    }
  }

  //Check if the last page of subjects has been loaded
  checkIfLastPageByDegree(){
    this.subjectService.getSubjectByDegreeId(this.degree.id).subscribe(
      allSubjects => {
        debugger
        this.lastPageLoaded = this.subjects[this.subjects.length-1].id == allSubjects[allSubjects.length-1].id;
        console.log('Resultado: ' + this.lastPageLoaded);
      }
    );
  }

  //Check if the last page of subjects has been loaded
  checkIfLastPageBySubject(){
    this.subjectService.getSubjectByName(this.textSearched).subscribe(
      subjects => {
        this.lastPageLoaded = this.subjects[this.subjects.length-1].id == subjects[subjects.length-1].id;
      }
    );
  }
}
