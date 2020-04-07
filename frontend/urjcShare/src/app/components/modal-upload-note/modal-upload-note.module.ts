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
import {AuthenticationService} from "../../authentication.service";




@Component({
  selector: 'modalUploadNote',
  templateUrl: 'modal-upload-note.html',
})
export class ModalUploadNoteModule implements OnInit {
  note: Note;
  name: string;
  professor: string;
  listDegrees: Degree[];
  degreeSelected: Degree ;
  listSubjects: Subject[];
  subjectSelected: string;
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
    this.subjectService.getSubjectByName(this.subjectSelected).subscribe(
      subjects =>{
        this.note = {
          name:this.name ,
          professor: this.professor ,
          subject: subjects[0],
          user: this.authenticationService.user,
          scores:[],
        };

        this.notesService.addNote(this.note).subscribe(
          note => {
            this.fileService.uploadFile(this.fileUser, note.id).subscribe(
              note => {
                alert('El apunte se ha subido correctamente.');
                this.router.navigate(['/']);
              },
              error => console.error("Error al guardar el fichero: " + error)
            )
          },
          error => {
            console.error("Error al subir apunte: " + error)
          }
        );
        this.activeModal.close();
      }
    );



  }
}
