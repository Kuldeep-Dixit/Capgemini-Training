import { Component, ViewChild } from '@angular/core';
import { Emp } from '../emp';
import { EmpserviceService } from '../empservice.service';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-addemployee',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './addemployee.component.html',
  styleUrl: './addemployee.component.css'
})
export class AddemployeeComponent {
  emp : Emp = new Emp();
  msg:string = '';
  constructor(public empService : EmpserviceService){}

  @ViewChild("frm")
  form ?: NgForm;

  addEmp(){
   let res= this.empService.addEmp(this.emp);
   if(res){ this.msg="Employee Added Successfully";
    this.emp=new Emp();
    this.form?.reset();
   }

   else this.msg = "Emp id already exists"
  }


}
