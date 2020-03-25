import { Routes, RouterModule } from '@angular/router';
import {SignUpComponent} from "./components/signUp.component";
import { ProfileComponent} from './components/profile.component';

const appRoutes = [
 { path: 'profile', component: ProfileComponent },
 { path: 'signUp', component: SignUpComponent }
]

export const routing = RouterModule.forRoot(appRoutes);
