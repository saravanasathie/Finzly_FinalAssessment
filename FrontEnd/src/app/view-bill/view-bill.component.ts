import { Component, OnInit } from '@angular/core';
import { Bill } from '../model/bill';
import { Invoice } from '../model/invoice';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-view-bill',
  templateUrl: './view-bill.component.html',
  styleUrls: ['./view-bill.component.css']
})
export class ViewBillComponent implements OnInit {

  billtopay:any=<Bill>{};
  invoiceinfo:any=<Invoice>{};
  constructor(private service:HttpService,
    private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.getIdFromURL();
  }

  getIdFromURL(){
      
    this.route.paramMap.subscribe((pragma)=>{
      console.log(pragma.get("id"));
      this.service.getSpecificBillData(pragma.get("id")).subscribe((response:any)=>{
        this.billtopay=response; 
        this.service.getInvoiceData(this.billtopay.billId).subscribe((response:any)=>{
          this.invoiceinfo=response;
      })
      })  
    })
}
goBack(){
  this.router.navigate(['/customer-bill-data']);
}


}
