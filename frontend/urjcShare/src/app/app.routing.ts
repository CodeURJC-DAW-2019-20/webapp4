import {SignUpComponent} from "./components/signUp.component";
import { ProfileComponent} from './components/profile.component';
import {Routes, RouterModule} from '@angular/router';
import {SignInComponent} from "./components/signIn.component";

const appRoutes = [
  {path: 'profile', component: ProfileComponent},
  {path: 'signUp', component: SignUpComponent},
  {path: 'signIn', component: SignInComponent}

]

export const routing = RouterModule.forRoot(appRoutes);
