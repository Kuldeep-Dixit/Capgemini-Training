import { Routes } from '@angular/router';
import { ViewemployeeComponent } from './viewemployee/viewemployee.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';

export const routes: Routes = [
    {path : 'viewall', component : ViewemployeeComponent},
    {path : 'add' , component : AddemployeeComponent}
];
