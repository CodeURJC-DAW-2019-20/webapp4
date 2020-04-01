import {Component, OnInit,} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {DegreeService} from "../../services/degree.service";
import {Degree} from "../../model/degree.model";
import {SubjectService} from "../../services/subject.service";
import {Subject} from "../../model/subject.model";


@Component({
  selector: 'modalUploadNote',
  templateUrl: 'modal-upload-note.html',
})
export class ModalUploadNoteModule implements OnInit {
  listDegrees: Degree[];
  degreeSelected: Degree ;
  listSubjects: Subject[];
  subjectSelected: Subject;

  constructor(public activeModal: NgbActiveModal, private degreeService: DegreeService , private subjectService: SubjectService) {
  }

  ngOnInit(){
    this.degreeService.getDegrees().subscribe(
      degrees =>{
          this.listDegrees = degrees;
      },
      error =>{
        console.error('Error al cargar los grados' + error)
      }
    )

  }

  loadSubject(degree){
    this.subjectService.getSubjectByDegreeId(degree.id).subscribe(
      subjects =>{
        this.listSubjects = subjects;
      },
      error=>{
        console.error('Error al cargar las asignaturas' + error)
      }
    )

  }
}
