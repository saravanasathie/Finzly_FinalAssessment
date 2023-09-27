import { Component, OnInit } from '@angular/core';
import { Transaction } from '../transaction';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-paidbills',
  templateUrl: './paidbills.component.html',
  styleUrls: ['./paidbills.component.css']
})
export class PaidbillsComponent implements OnInit {

  userId:any=sessionStorage.getItem("customerId");
  paidBills!:Transaction[];
  constructor(  private route: Router,
    private customerService : EmployeeService
) { }

  ngOnInit(): void 
  {
      this.loadPaidBills();
  

}
loadPaidBills() {
  this.customerService.loadPaidBills().subscribe((response) => {
    console.log(response); 
    this.paidBills=response; 
  });
}
}
