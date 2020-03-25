import { Routes, RouterModule } from '@angular/router';
import {SignUpComponent} from "./components/signUp.component";
import { ProfileComponent} from './components/profile.component';
import {DegreeListComponent} from "./components/degree-list.component";

const appRoutes = [
 { path: 'profile', component: ProfileComponent },
 { path: 'signUp', component: SignUpComponent },
  { path: 'degrees', component: DegreeListComponent },
]

export const routing = RouterModule.forRoot(appRoutes);
