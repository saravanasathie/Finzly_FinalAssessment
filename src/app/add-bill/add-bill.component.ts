import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { Transaction } from '../transaction';

@Component({
  selector: 'app-add-bill',
  templateUrl: './add-bill.component.html',
  styleUrls: ['./add-bill.component.css']
})
export class AddBillComponent implements OnInit {

  transaction: Transaction = {
    tId: 0, 
    transactionMethod: '', 
    unitConsumption: 0, 
    status: '', 
    totalAmount: 0, 
    discount: 0, 
    startDate: new Date(), 
    endDate: new Date(), 
    rate: 0, 
    customer: {
      cid: 0, 
      name: '', 
      phoneNumber:'',
    emailId:''
    },
    referenceNumber: '', 
  };
  
  constructor(private service:EmployeeService,
              private router:Router) { }

  ngOnInit(): void {
    this.submitForm();
  }

  submitForm() {
    this.service.addCustomerBillData(this.transaction)
    .subscribe((response:any)=>{
      console.log(response);
      this.router.navigate(['/customer-data']);
    })
  }
}

