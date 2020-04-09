import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {NotesService} from "../../services/notes.service";
import {AuthenticationService} from "../../authentication.service";
import {User} from "../../model/user.model";
import {Note} from "../../model/note.model";

@Component({
  selector: 'graph',
  templateUrl: './graph.component.html'
})
export class GraphComponent{
  constructor(){}
  title = 'Grafico de Valoraciones de Apuntes';
  notes:Note[];
  user:User;
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
  onSelect(event){
    console.log(event);
  }
  createGraph(notes:Note[]){
    for (let note of notes) {
      this.data.push({name: note.name, value:5});
    }
    console.log(this.data)
    this.data=[...this.data];
    console.log(this.data)
  }
  get dataNote(){
    return this.data
  }
  // data goes here
  public data=[

  ]
}
