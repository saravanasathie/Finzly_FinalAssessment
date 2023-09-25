import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
@Component({
  selector: 'app-transaction-tracking',
  templateUrl: './transaction-tracking.component.html',
  styleUrls: ['./transaction-tracking.component.css']
})
export class TransactionTrackingComponent implements OnInit {

  paymentTrakingData:any[]=[];

  constructor(private httpservice:HttpService) { }

  ngOnInit(): void {
    this.GetAllData();
  }

  GetAllData(){
    this.httpservice.getPaymentTrakingData()
    .subscribe((response:any)=>{
      this.paymentTrakingData=response;
    })
  }

}
