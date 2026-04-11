import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterOutlet } from '@angular/router';
import { EmpserviceService } from '../empservice.service';

@Component({
  selector: 'app-viewemployee',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink,],
  templateUrl: './viewemployee.component.html',
  styleUrl: './viewemployee.component.css'
})
export class ViewemployeeComponent {
  constructor(public empService : EmpserviceService){ }
}
