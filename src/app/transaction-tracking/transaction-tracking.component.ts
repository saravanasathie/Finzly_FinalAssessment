import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Transaction } from '../transaction';

@Component({
  selector: 'app-transaction-tracking',
  templateUrl: './transaction-tracking.component.html',
  styleUrls: ['./transaction-tracking.component.css']
})
export class TransactionTrackingComponent implements OnInit {

  Transaction:Transaction[]=[];


  constructor(private httpservice:EmployeeService) { }

  ngOnInit(): void {
    this.GetAllData();
  }

  GetAllData(){
    this.httpservice.getTransactionData()
    .subscribe((response:any)=>{
      this.Transaction=response;
    })
  }
}
