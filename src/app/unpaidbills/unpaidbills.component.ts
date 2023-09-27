import { Component, OnInit } from '@angular/core';
import { Transaction } from '../transaction';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { CustomerData } from '../customer-data';

@Component({
  selector: 'app-unpaidbills',
  templateUrl: './unpaidbills.component.html',
  styleUrls: ['./unpaidbills.component.css']
})
export class UnpaidbillsComponent implements OnInit {



  userId:any=sessionStorage.getItem('empId');
  SelectedBill!:number;
  notinuse!:number;
  // CustomerData!:CustomerData[];
  unPaidBills!:Transaction[];

  constructor(private customerService : EmployeeService,private router:Router) { }
  
  
  navigateToChoicePayment(billId: number): void {
    this.SelectedBill=billId;
    sessionStorage.setItem("billId", ""+ this.SelectedBill);

    // Navigate to the ChoicePaymentComponent when the "Pay Now" button is clicked
    this.router.navigate(['/customer-data']);
  }

  ngOnInit(){
    this.loadUnPaidBills();
    // this.loadCustomerData();
  }
  goToInvoice(tid:any){
       sessionStorage.setItem("transactionId",tid);
       this.router.navigate(['/invoice']);
  }

  loadUnPaidBills() {
    this.customerService.loadUnAllPaidBills().subscribe((response) => {
      console.log(response); 
      this.unPaidBills=response;
      console.log(this.SelectedBill);
    });


}
// loadCustomerData(){
//   this.customerService.loadUnAllPaidBills().subscribe((response) => {
//     console.log(response); 
//     this.unPaidBills=response as Transaction[];
//     console.log(this.SelectedBill);
//   });

}

