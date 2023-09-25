import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private router:Router) { }

  navigateToCustomerBillData(){
    this.router.navigate(['/customer-bill-data']);
    
  }
  navigateToTransactionTracking(){
    this.router.navigate(['/transaction-tracking']);
  }
  ngOnInit(): void {
  }

}
