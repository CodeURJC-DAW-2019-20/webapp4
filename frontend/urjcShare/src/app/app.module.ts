import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { routing } from './app.routing';
import { AppComponent } from './components/app.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { EditModalComponent } from './components/editModal.component';

@NgModule({
  declarations: [
    AppComponent,
    EditModalComponent
  ],
  imports: [
    BrowserModule,
    routing,
    NgbModule
  ],
  entryComponents:[
    EditModalComponent
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
