import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { routing } from './app.routing';
import { AppComponent } from './components/app/app.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NgxSpinnerModule } from "ngx-spinner";
import { EditModalComponent } from './components/editModal/editModal.component';
import {ModalAdminComponent} from "./components/modalAdmin/modalAdmin.component";
import { NavComponent } from './components/nav/nav.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { NotesComponent } from './components/notes/notes.component';
import {SignInComponent} from "./components/signIn/signIn.component";
import {SignUpComponent} from "./components/signUp/signUp.component";
import {DegreeListComponent} from "./components/degree/degree-list.component";
import {ErrorComponent} from "./components/error/error.component";
import {IndexComponent} from "./components/index/index.component";
import {LoginerrorComponent} from "./components/loginerror/loginerror.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {UserExistErrorComponent} from "./components/userExistError/userExistError.component";
import { SubjectsComponent } from './components/subjects/subjects.component';
import { RankingComponent } from './components/ranking/ranking.component';
import {ModalUploadNoteModule} from "./components/modal-upload-note/modal-upload-note.module";
import {AuthenticationService} from "./authentication.service";
import {BasicAuthInterceptor} from "./basic-auth.interceptor";
import {ErrorInterceptor} from "./error.interceptor";
import {LogOutComponent} from "./components/logOut/logOut.component";

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
    RankingComponent,
    ModalUploadNoteModule,
    ListNotesComponent
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
    ModalAdminComponent,
    ModalUploadNoteModule
  ],
  providers: [AuthenticationService,
    { provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
