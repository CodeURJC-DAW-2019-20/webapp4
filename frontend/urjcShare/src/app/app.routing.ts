import {SignUpComponent} from "./components/signUp/signUp.component";
import { ProfileComponent} from './components/profile/profile.component';
import {Routes, RouterModule} from '@angular/router';
import {SignInComponent} from "./components/signIn/signIn.component";
import {DegreeListComponent} from "./components/degree/degree-list.component";
import {IndexComponent} from "./components/index/index.component";
import {LoginerrorComponent} from "./components/loginerror/loginerror.component";
import {ErrorComponent} from "./components/error/error.component";
import {UserExistErrorComponent} from "./components/userExistError/userExistError.component";
import {SubjectsComponent} from "./components/subjects/subjects.component";
import {RankingComponent} from "./components/ranking/ranking.component";
import {NotesComponent} from "./components/notes/notes.component";



const appRoutes = [
  {path: 'profile', component: ProfileComponent},
  {path: 'signUp', component: SignUpComponent},
  {path: 'signIn', component: SignInComponent},
  {path: 'degrees', component: DegreeListComponent },
  {path: '', component: IndexComponent},
  {path: 'login-error', component: LoginerrorComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'user-error', component: UserExistErrorComponent},
  {path: 'ranking', component: RankingComponent},
  {path: 'subjects', component: SubjectsComponent},
  {path: 'degrees/:id/subjects', component: SubjectsComponent},
  {path: 'note/:id', component: NotesComponent}

]

export const routing = RouterModule.forRoot(appRoutes);
