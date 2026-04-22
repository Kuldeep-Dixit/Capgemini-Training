import { Routes } from '@angular/router';
import { SearchFormComponent } from './search-form/search-form.component';
import { ProductListComponent } from './product-list/product-list.component';

export const routes: Routes = [
    {path: 'search', component: SearchFormComponent},
    {path: 'products', component: ProductListComponent}
];
