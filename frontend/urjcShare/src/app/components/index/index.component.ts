import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector:'index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit{
  searchType: string;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router){

  }

  ngOnInit() {
  }

  searchContent(item: string){

    if(this.searchType == "Degree"){
      this.router.navigate(['/degrees'], { queryParams: { textSearched: item } });
    }
    else if(this.searchType == "Subject"){
      this.router.navigate(['/subjects'], { queryParams: { textSearched: item } });
    }
  }
}
