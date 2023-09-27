import { Component, OnInit } from '@angular/core';
import { CustomerData } from '../customer-data';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';

import { Transaction } from '../transaction';



@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  CustomerData:any[]=[];  

  searchText: string = ''; 
  obj:any=<CustomerData>{};
  constructor(private httpservice:EmployeeService,
    private router:Router) { }

  ngOnInit() {
    this.GetAllData();
  }

  GetAllData(){
    this.httpservice.getallBill()
    .subscribe((resonse:any)=>{
      this.CustomerData=resonse;
    });

  }
  navigateToAddCustomerManual(){
    this.router.navigate(['/add-customer-manual']);
  }
  navigateToAddCustomerCSV(){
    this.router.navigate(['/add-customer-csv'])
  }
  navigateToAddBill(){
    this.router.navigate(['/add-bill'])
  }
  onButtonClick(item: any) {
    const itemStatusLower = item.status.toLowerCase();
  
    console.log('Item Status:', itemStatusLower);
  
    if (itemStatusLower === 'success') {
      // this.toaster.error("Bill Already Paid");
      console.log("Bill Paid");
      
    } else if (itemStatusLower === 'pending') { 
      console.log('Updating status to Paid...');
      this.httpservice.updatePendingStatus(item)
        .subscribe((response: any) => {
          console.log(response);
          // this.toaster.success("Customer Data Updated Successfully")
          this.GetAllData();
        });
    }
  }
  showInvoice(Transaction:any){
    this.router.navigate(['/viewbill',Transaction.tId]);
  }

}
