import {Component, OnInit} from '@angular/core';
import {NotesService} from "../../services/notes.service";
import {Note} from "../../model/note.model";
import {ActivatedRoute} from "@angular/router";
import {not} from "rxjs/internal-compatibility";

@Component({
  selector: 'app-list-notes',
  templateUrl: './list-notes.component.html',
  styleUrls: ['./list-notes.component.css']
})
export class ListNotesComponent implements OnInit {
  listNotes: Note[]

  constructor(private notesService: NotesService,
              private route: ActivatedRoute) {
    this.listNotes = []
  }

  ngOnInit(): void {
    this.notesService.getNotesBySubject(this.route.snapshot.paramMap.get('id')).subscribe(
      notes => {
        this.listNotes = notes
      },
      error => {
        this.listNotes = []
      });
  }

}
