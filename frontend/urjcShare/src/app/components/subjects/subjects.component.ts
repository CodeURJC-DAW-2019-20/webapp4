import { Component, OnInit } from '@angular/core';
import {SubjectService} from "../../services/subject.service";
import {Subject} from "../../model/subject.model";
import {ActivatedRoute, Router} from "@angular/router";
import {DegreeService} from "../../services/degree.service";
import {Degree} from "../../model/degree.model";


@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styles: []
})
export class SubjectsComponent  {
  previousComponent: string;
  textSearched: string;
  subjects: Subject[];
  subjectLoaded:boolean;
  subject: Subject;




  constructor(private subjectService: SubjectService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private degreeService: DegreeService) {
  }

  ngOnInit(){
    this.subjectLoaded = false;
    this.textSearched = this.activatedRoute.snapshot.queryParams['textSearched'];
    this.previousComponent = this.activatedRoute.snapshot.queryParams['previousComponent'];
    if (this.previousComponent == 'index'){

      this.subjectService.getSubjectByName(this.textSearched).subscribe(
        subject=>{
          this.subjectLoaded=true;
          this.subjects = subject
        },
        error =>{
          this.subjectLoaded=true;
          console.error("Error al cargar la asignatura bucada:" + error)
        }
      )

    }else {

      this.degreeService.getDegreesByName(this.textSearched).subscribe(
        degree=>{
            this.subjectService.getSubjectByDegreeId(degree[0].id).subscribe(
              subject=>{
                this.subjects = subject;
                this.subjectLoaded = true;
              },
              error =>{
                console.error("Error al cargar la asignatura" +error)
              }
            );
        },
        error =>{
          console.error("Error al cargar el grado" + error)

        }

      )
    }


  }

}
