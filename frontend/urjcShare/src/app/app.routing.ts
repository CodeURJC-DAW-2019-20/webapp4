import {SignUpComponent} from "./components/signUp.component";
import { ProfileComponent} from './components/profile.component';
import {Routes, RouterModule} from '@angular/router';
import {SignInComponent} from "./components/signIn.component";
import {DegreeListComponent} from "./components/degree-list.component";
import {IndexComponent} from "./components/index.component";
import {LoginerrorComponent} from "./components/loginerror.component";
import {ErrorComponent} from "./components/error.component";
import {UserExistErrorComponent} from "./components/userExistError.component";
import {SubjectsComponent} from "./components/subjects/subjects.component";
import {RankingComponent} from "./components/ranking.component";



const appRoutes = [
  {path: 'profile', component: ProfileComponent},
  {path: 'signUp', component: SignUpComponent},
  {path: 'signIn', component: SignInComponent},
  {path: 'degrees', component: DegreeListComponent },
  {path: '', component: IndexComponent},
  {path: 'login-error', component: LoginerrorComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'user-error', component: UserExistErrorComponent}
]

export const routing = RouterModule.forRoot(appRoutes);
