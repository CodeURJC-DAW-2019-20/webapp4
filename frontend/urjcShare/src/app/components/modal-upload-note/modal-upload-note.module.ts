import {Component, OnInit,} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {DegreeService} from "../../services/degree.service";
import {Degree} from "../../model/degree.model";
import {SubjectService} from "../../services/subject.service";
import {Subject} from "../../model/subject.model";
import {ImageService} from "../../services/image.service";
import {NotesService} from "../../services/notes.service";
import {Note} from "../../model/note.model";
import {Router} from "@angular/router";
import {User} from "../../model/user.model";
import {Score} from "../../model/score.model";
import {AuthenticationService} from "../../authentication.service";




@Component({
  selector: 'modalUploadNote',
  templateUrl: 'modal-upload-note.html',
})
export class ModalUploadNoteModule implements OnInit {
  note: Note;
  listDegrees: Degree[];
  degreeSelected: Degree ;
  listSubjects: Subject[];
  subjectSelected: Subject;
  fileUser: File;



  constructor(public activeModal: NgbActiveModal,
              private degreeService: DegreeService ,
              private subjectService: SubjectService,
              private fileService: ImageService,
              private notesService: NotesService,
              private router: Router,
              private authenticationService: AuthenticationService) {
  }

  ngOnInit(){
    this.degreeService.getDegrees().subscribe(
      degrees =>{
          this.listDegrees = degrees;
      },
      error =>{
        console.error('Error al cargar los grados' + error)
      }
    );

    this.note = {
    name:'' ,
    professor: '',
    subject: this.subjectSelected,
    user: this.authenticationService.user,
    scores:[],
    };

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

  uploadFile( event){
    this.fileUser = event.target.files[0];
  }

  save() {
    this.notesService.addNote(this.note).subscribe(
      note => {
        this.fileService.uploadFile(this.fileUser, note.id).subscribe(
          note => {
            this.router.navigate(['/']);
          },
          error => console.error("Error al guardar la imagen: " + error)
        )
      },
      error => {
        console.error("Error al crear el usuario: " + error)
      }
    );
  }
}
