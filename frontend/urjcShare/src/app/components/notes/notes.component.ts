import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute, ParamMap} from '@angular/router';
import {NgbRatingConfig} from "@ng-bootstrap/ng-bootstrap";
import {NotesService} from "../../services/notes.service";
import {AuthenticationService} from "../../authentication.service";

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {
  noteLoaded: boolean;
  note;
  currentRate;
  constructor(private notesService: NotesService,
              private route: ActivatedRoute,
              private config: NgbRatingConfig,
              private authenticationService:AuthenticationService) {
    this.currentRate = 3
    config.max = 5;
    this.note = null
   }


  ngOnInit(): void {
    this.noteLoaded = false;
    this.notesService.getNoteByID(this.route.snapshot.paramMap.get('id')).subscribe( note => {
      console.log(note);
      this.note = note;
      this.noteLoaded = true;
    },error=>{this.noteLoaded = true;})
  }

  vote ():void {
    this.notesService.voteNote(this.note.id, this.currentRate).subscribe( response=> {
      console.log(response)
    }, error =>{
      console.log(error)
    })
  }
  get login() {
    return this.authenticationService.logged
  }

}
