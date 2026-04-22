import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { ProductServiceService } from './product.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  constructor(public service: ProductServiceService) {}
  title = 'E-commerce';
  subtitle= 'Welcome to our online store';

  ngOnInit() {
  this.service.getProducts().subscribe(data => {
    this.service.products = data;
    console.log(this.service.products);
  });
}}
