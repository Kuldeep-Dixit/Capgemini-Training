import { Component, EventEmitter, Output } from '@angular/core';
import { ProductServiceService } from '../product.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './search-form.component.html',
  styleUrl: './search-form.component.css'
})
export class SearchFormComponent {

  constructor(public service: ProductServiceService) {}
  searchText: string = '';
  filteredProducts: any[] = this.service.products;

  search(){
    if(this.searchText.trim() === ''){
      this.filteredProducts = this.service.products;
    } else {
      this.filteredProducts = this.service.products.filter(product => 
        product.pname.toLowerCase().includes(this.searchText.toLowerCase())
      );
    }
  }
}
