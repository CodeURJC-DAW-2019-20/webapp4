import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {AuthenticationService} from "../../authentication.service";
import {User} from "../../model/user.model";
import {Note} from "../../model/note.model";

@Component({
  selector: 'graph',
  templateUrl: './graph.component.html'
})
export class GraphComponent implements OnInit{
  constructor(
    private userService:UserService,
    private authenticationService:AuthenticationService

  ) {
  }

  title = 'Gráfico de valoraciones de apuntes';
  notes: Note[];
  user: User;
  view: any[] = [600, 400];

  // options for the chart
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Apunte';
  showYAxisLabel = true;
  yAxisLabel = 'Valoración';
  colorScheme = {
    domain: ['#9370DB', '#87CEFA', '#FA8072', '#FF7F50', '#90EE90', '#9370DB']
  };

  onSelect(event) {
    console.log(event);
  }

  createGraph(notes: Note[]) {
    for (let note of notes) {
      this.data.push({name: note.name, value: 5});
    }
    this.data = [...this.data]
    console.log(this.data)
  }
  ngOnInit(): void {
    this.data = []
    this.user = this.authenticationService.getUser();
    this.userService.getGraficNotesUser(this.user.id).subscribe(
      notesGraf => {
        this.data = notesGraf;
      }
    )
  }

  get dataNote() {
    return this.data
  }

  // data goes here
  public data:any
}
