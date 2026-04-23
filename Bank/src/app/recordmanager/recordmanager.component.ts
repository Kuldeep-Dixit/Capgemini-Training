import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { txns } from '../bank';

@Component({
  selector: 'app-recordmanager',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './recordmanager.component.html',
  styleUrl: './recordmanager.component.css'
})
export class RecordmanagerComponent {

  transactions: any[] = [];
  displayedTransactions: any[] = [];
  selectedDate: string = '';

  ngOnInit(): void {
    this.transactions = this.getTransactions();
    this.displayedTransactions = [...this.transactions];
  }

  getTransactions() {
    return txns;
  }

  filter(): void {
    if (!this.selectedDate) return;

    this.displayedTransactions = this.transactions.filter(
      t => t.date === this.selectedDate
    );
  }

  sortByAmount(): void {
    this.displayedTransactions = [...this.displayedTransactions].sort(
      (a, b) => a.amount - b.amount
    );
  }


}
