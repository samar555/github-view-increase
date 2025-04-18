import { Routes } from '@angular/router';

import { HomeComponent } from './shared/home/home.component';
import { DashboaredComponent } from './shared/dashboared/dashboared.component';

export const routes: Routes = [


{
    path:"",
    loadComponent: ()=>import("./shared/home/home.component").then(c=>c.HomeComponent)
},
{
path:"dashboared",
loadComponent: ()=>import("./shared/dashboared/dashboared.component").then(c=>c.DashboaredComponent)
}

];
