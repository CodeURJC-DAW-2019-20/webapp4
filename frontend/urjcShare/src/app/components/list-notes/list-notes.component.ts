import {Component, OnInit} from '@angular/core';
import {NotesService} from "../../services/notes.service";
import {Note} from "../../model/note.model";
import {ActivatedRoute} from "@angular/router";
import {Subject} from "../../model/subject.model";
import {SubjectService} from "../../services/subject.service";
import {NgxSpinnerService} from "ngx-spinner";

@Component({
  selector: 'app-list-notes',
  templateUrl: './list-notes.component.html',
  styleUrls: ['./list-notes.component.css']
})
export class ListNotesComponent implements OnInit {
  listNotes: Note[];
  page: number;
  size: number = 10;
  subjectParam: string;
  subject: Subject;
  lastPageLoaded: boolean;
  notesLoaded: boolean;

  constructor(private notesService: NotesService,
              private route: ActivatedRoute,
              private subjectService: SubjectService,
              private spinner: NgxSpinnerService) {
    this.listNotes = []
  }

  ngOnInit(): void {
    this.page = 0;
    this.notesLoaded = false;
    this.subjectParam = this.route.snapshot.queryParams['subject'];

    this.subjectService.getSubjectByName(this.subjectParam).subscribe(
      subjects => {
        this.subject = subjects[0];
        this.notesService.getNotesBySubjectPaged(this.subject.id, this.page, this.size).subscribe(
          notes => {
            this.listNotes = notes;
            this.page++;
            this.checkIfLastPage();
            this.notesLoaded = true;
          },
          error => {
            this.listNotes = []
            this.notesLoaded = true;
          });
      }
    )

  }

  //Check if the last page of notes has been loaded
  checkIfLastPage() {
    this.notesService.getNotesBySubject(this.subject.id).subscribe(
      allNotes => {
        this.lastPageLoaded = allNotes == null || this.listNotes[this.listNotes.length - 1].id == allNotes[allNotes.length - 1].id;
      }
    );
  }

  loadNotes() {
    this.spinner.show();
    this.notesService.getNotesBySubjectPaged(this.subject.id, this.page, this.size).subscribe(
      notes => {
        this.listNotes = this.listNotes.concat(notes);
        this.page++;
        this.checkIfLastPage();
        this.spinner.hide();
      }
    );

  }
}
