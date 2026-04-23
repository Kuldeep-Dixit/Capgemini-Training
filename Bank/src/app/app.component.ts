import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RecordmanagerComponent } from './recordmanager/recordmanager.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RecordmanagerComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Bank';
}
