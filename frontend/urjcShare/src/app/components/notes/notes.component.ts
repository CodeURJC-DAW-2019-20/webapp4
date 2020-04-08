import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute, ParamMap} from '@angular/router';
import {NgbRatingConfig} from "@ng-bootstrap/ng-bootstrap";
import {NotesService} from "../../services/notes.service";

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  note
  currentRate
  constructor(private notesService: NotesService,
              private route: ActivatedRoute,
              private config: NgbRatingConfig) {
    this.currentRate = 3
    config.max = 5;
    this.note = null
   }


  ngOnInit(): void {
    this.notesService.getNoteByID(this.route.snapshot.paramMap.get('id')).subscribe( note => {
      console.log(note)
      this.note = note
    },error=>{})
  }

  vote ():void {
    this.notesService.voteNote(this.note.id, this.currentRate).subscribe( response=> {
      console.log(response)
    }, error =>{
      console.log(error)
    })
  }

}
