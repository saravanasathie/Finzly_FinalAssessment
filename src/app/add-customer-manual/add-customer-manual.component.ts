import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomerData } from "../customer-data";
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-customer-manual',
  templateUrl: './add-customer-manual.component.html',
  styleUrls: ['./add-customer-manual.component.css']
})
export class AddCustomerManualComponent implements OnInit {
  CustomerData: CustomerData = {
    cid: 0,
    name: '',
    phoneNumber: '',
    emailId: ''
  };

  constructor(private service: EmployeeService, private router: Router) {}

  ngOnInit(): void {}

  

  submitForm() {
    this.service.addCustomer(this.CustomerData).subscribe((response: any) => {
      console.log(response);
      this.router.navigate(['/customer-data']);
    });
  }
}
