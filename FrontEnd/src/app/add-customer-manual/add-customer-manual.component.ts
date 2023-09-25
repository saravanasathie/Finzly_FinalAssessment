import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomerBillData } from '../model/customer-bill-data';
import { HttpService } from '../http.service';
import { ToastrService  } from 'ngx-toastr';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-customer-manual',
  templateUrl: './add-customer-manual.component.html',
  styleUrls: ['./add-customer-manual.component.css']
})
export class AddCustomerManualComponent implements OnInit {

  customerData:CustomerBillData=<CustomerBillData>{};
 

  constructor(private service:HttpService,
              private toaster:ToastrService,
              private router:Router) { }

  ngOnInit(): void {
  }
  submitForm() {
    this.service.addCustomerBillData(this.customerData)
    .subscribe((response:any)=>{
      console.log(response);
      this.toaster.success("Customer Data Added Successfully")
      this.router.navigate(['/customer-bill-data']);
    })
    
  }


}
