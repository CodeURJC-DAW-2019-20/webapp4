import {SignUpComponent} from "./components/signUp.component";
import { ProfileComponent} from './components/profile.component';
import {Routes, RouterModule} from '@angular/router';
import {SignInComponent} from "./components/signIn.component";
import {DegreeListComponent} from "./components/degree-list.component";
import {IndexComponent} from "./components/index.component";


const appRoutes = [
  {path: 'profile', component: ProfileComponent},
  {path: 'signUp', component: SignUpComponent},
  {path: 'signIn', component: SignInComponent},
  {path: 'degrees', component: DegreeListComponent },
  {path: 'index', component: IndexComponent},

]

export const routing = RouterModule.forRoot(appRoutes);
