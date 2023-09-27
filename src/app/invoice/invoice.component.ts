import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Transaction } from '../transaction';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  transaction!:Transaction;
  transactionId!:any;
  selectedPaymentMethod!:any;
  constructor(private http:EmployeeService) { }

  ngOnInit(){
    this.transactionId=sessionStorage.getItem("transactionId");
    this.getATransactionByTID(this.transactionId);
    console.log(this.transactionId);

  }
  getATransactionByTID(transactionId:number){
    this.http.getATransactionByTID(this.transactionId).subscribe(
      (response)=>{
        this.transaction = response;
      },
      (error)=>{
        console.log("Error");
      }
    )
  }
}
