import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { routing } from './app.routing';
import { AppComponent } from './components/app.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NgxSpinnerModule } from "ngx-spinner";
import { EditModalComponent } from './components/editModal.component';
import {ModalAdminComponent} from "./components/modalAdmin.component";
import { NavComponent } from './components/nav.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { NotesComponent } from './components/notes.component';
import {SignInComponent} from "./components/signIn.component";
import {SignUpComponent} from "./components/signUp.component";
import {DegreeListComponent} from "./components/degree-list.component";
import {ErrorComponent} from "./components/error.component";
import {IndexComponent} from "./components/index.component";
import {LoginerrorComponent} from "./components/loginerror.component";
import {ProfileComponent} from "./components/profile.component";
import {UserExistErrorComponent} from "./components/userExistError.component";
import { SubjectsComponent } from './components/subjects/subjects.component';
import { RankingComponent } from './components/ranking.component';
@NgModule({
  declarations: [
    AppComponent,
    EditModalComponent,
    ModalAdminComponent,
    NavComponent,
    NotesComponent,
    SignInComponent,
    SignUpComponent,
    DegreeListComponent,
    ErrorComponent,
    IndexComponent,
    LoginerrorComponent,
    ProfileComponent,
    UserExistErrorComponent,
    SubjectsComponent,
    RankingComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    routing,
    NgbModule,
    HttpClientModule,
    NgxSpinnerModule
  ],
  entryComponents:[
    EditModalComponent,
    ModalAdminComponent
  ],
  providers: [

  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
