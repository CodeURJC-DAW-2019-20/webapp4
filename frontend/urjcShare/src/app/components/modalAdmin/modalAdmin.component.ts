import {Component, OnInit} from "@angular/core";
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import {Degree} from "../../model/degree.model";
import {Subject} from "../../model/subject.model";
import {DegreeService} from "../../services/degree.service";
import {SubjectService} from "../../services/subject.service";

@Component({
  selector: 'modalAdmin',
  templateUrl: './modalAdmin.component.html',
})
export class ModalAdminComponent implements OnInit{

  degreeNameTab1: string;
  degreeNameTab2: string;
  subjectName: string;
  degrees: Degree[];

  constructor(public activeModal: NgbActiveModal, private degreeService: DegreeService, private subjectService: SubjectService) {}

  ngOnInit(): void {
    this.degreeService.getDegrees().subscribe(
      degrees => this.degrees = degrees,
      error => console.error("Error al cargar los grados existentes "+ error)
    )
  }

  saveDegree(){
    let degree: Degree;
    degree = {name: this.degreeNameTab1, subjects: []};
    this.degreeService.addDegree(degree).subscribe(
      degree => {this.activeModal.close('Close click')},
      error => {
        console.error("No se ha podido crear el grado: "+ error),
          this.activeModal.close('Close click');
      }
    )
  }

  saveSubject(){
    let subject: Subject;
    console.info("Grado: "+ this.degreeNameTab2)
    console.info("Asignatura: "+ this.subjectName);
    this.degreeService.getDegreesByName(this.degreeNameTab2).subscribe(
      degrees => {
        subject = {name: this.subjectName, degree: degrees[0], notes: []};
        this.subjectService.addSubject(subject).subscribe(
          subject => this.activeModal.close('Close click'),
          error => console.error("Error al crear la asignatura "+ this.subjectName)
        )
      },
      error => console.error("Error al crear la asignatura "+ this.subjectName)
    )

  }


}
