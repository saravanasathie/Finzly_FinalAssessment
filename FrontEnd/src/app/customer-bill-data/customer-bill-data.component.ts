import { Component, OnInit } from '@angular/core';
import { CustomerBillData } from '../model/customer-bill-data';
import { HttpService } from '../http.service';
import { ToastrService  } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-bill-data',
  templateUrl: './customer-bill-data.component.html',
  styleUrls: ['./customer-bill-data.component.css']
})
export class CustomerBillDataComponent implements OnInit {

  customerBillData:any[]=[];  //for storing customer bill data
  searchText: string = ''; 
  obj:any=<CustomerBillData>{};
 

  constructor(private httpservice:HttpService,
              private toaster:ToastrService,
              private router:Router) { }

  ngOnInit(): void {
    this.GetAllData();

    
  }

  GetAllData(){
    this.httpservice.getAllCustomerBillRecord()
    .subscribe((resonse:any)=>{
      this.customerBillData=resonse;
    });

  }
 
  
  onButtonClick(item: any) {
    const itemStatusLower = item.billStatus.toLowerCase();
  
    console.log('Item Status:', itemStatusLower);
  
    if (itemStatusLower === 'paid') {
      this.toaster.error("Bill Already Paid");
      
    } else if (itemStatusLower === 'pending') { // Check for 'pending' here
      console.log('Updating status to Paid...');
      this.httpservice.updatePendingStatus(item)
        .subscribe((response: any) => {
          console.log(response);
          this.toaster.success("Customer Data Updated Successfully")
          this.GetAllData();
        });
    }
  }


  navigateToAddCustomerManual(){
    this.router.navigate(['/add-customer-manual']);
  }

  navigateToAddCustomerCSV(){
    this.router.navigate(['/add-customer-csv'])
  }
  
  showInvoice(bill:any){
    this.router.navigate(['/viewbill',bill.billId])
  }

}
