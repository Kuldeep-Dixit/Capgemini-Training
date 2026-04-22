import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  products: any[] = [];

  private url = 'assets/db.json';

  constructor(public http: HttpClient) { }

  getProducts(): Observable<any> {
    return this.http.get<any[]>('http://localhost:4200/assets/db.json');
  }

  deleteProduct(id: number) {
    let idx = this.products.findIndex(p => p.pid === id);
      this.products.splice(idx, 1);
    }
  


}
