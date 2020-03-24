import { Routes, RouterModule } from '@angular/router';
import {SignUpComponent} from "./signUp.component";


const appRoutes = [
 { path: 'signUp', component: SignUpComponent }
]

export const routing = RouterModule.forRoot(appRoutes);
