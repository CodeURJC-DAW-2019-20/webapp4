import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute, ParamMap} from '@angular/router';
import {NgbRatingConfig} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-notes',
  templateUrl: '../html/notes.component.html',
  styleUrls: ['../css/notes.component.css']
})
export class NotesComponent implements OnInit {
  note
  currentRate
  constructor(
    private route: ActivatedRoute,
    private config: NgbRatingConfig
  ) {
    this.currentRate = 3
    config.max = 5;
    this.note = {
      id: '',
      name: 'Tema 1',
      professor: 'Garzas',
      subject: {name:'Lengua'},
    }
  }

  ngOnInit(): void {
        this.note.id = this.route.snapshot.paramMap.get('id')
  }

}
