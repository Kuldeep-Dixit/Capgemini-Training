import { Injectable } from '@angular/core';
import { Emp } from './emp';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class EmpserviceService {
  emp : Emp[] = [
    new Emp(1, 'Kuldeep Dixit', 180000.0, '2016-02-21'),
    new Emp(7, 'Sameer Sidiqque', 100000.0, '2014-07-12'),
    new Emp(2, 'Manoj Sharma', 80000.0, '2017-09-16'),
    new Emp(4, 'Zaid Rafique', 120000.0, '2019-08-14'),
    new Emp(5, 'Satveer Singh', 50000.0, '2019-08-27')
  ]

  constructor(public router : Router) { }

  deleteEmp(empid ?: number){
    let idx = this.emp.findIndex(e => e.empId == empid)
    this.emp.splice(idx, 1);
  }

  addEmp(em : Emp){
    let idx = this.emp.findIndex(e => e.empId === em.empId);
    if(idx >= 0) return false;
    this.emp.push(em);
    return true;
  }
}
