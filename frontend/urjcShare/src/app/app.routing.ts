import { Routes, RouterModule } from '@angular/router';
import {SignUpComponent} from "./signUp.component";
import { ProfileComponent} from './profile.component';

const appRoutes = [
 { path: 'profile', component: ProfileComponent },
 { path: 'signUp', component: SignUpComponent }
]

export const routing = RouterModule.forRoot(appRoutes);
