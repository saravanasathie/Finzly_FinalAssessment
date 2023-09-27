import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from './employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  
  

  constructor(private http: HttpClient) { }

  baseUrl = "http://localhost:8080";

  

  getallBill() : Observable<any> {
    return this.http.get(`${this.baseUrl}/cus/getcus`);
  
  }

  loadPaidBills(): Observable<any> {
    return this.http.get(`${this.baseUrl}/trans/getsuccess`);
  }

  loadUnAllPaidBills(): Observable<any> {
    return this.http.get(`${this.baseUrl}/trans/getpending`);
  }
  getATransactionByTID(tid:number):Observable<any> {
    return this.http.get(`${this.baseUrl}/trans/gettransactionids/${tid}`)
  }


  // InvoiceComponent(userId:number,SelectedBill:number):Observable<any> {
  //   return this.http.get(`${this.baseUrl}getAlltranctionBillInvoice/${userId}/${SelectedBill}`);
  // }
  // PaymentMethodMode(userId:number,SelectedBill:number,paymnetMethod:number):Observable<string> {
  //   return this.http.get<string>(`${this.baseUrl}setAlltranctionByIdAndPaymentId/${userId}/${SelectedBill}/${paymnetMethod}`);
  // }
  // ConformPayment(userId:number,SelectedBill:number){
  //   return this.http.get<string>(`${this.baseUrl}getAlltranctionPaymentStatusUpdate/${userId}/${SelectedBill}`);
  // }


  getEmployeeById(id: number): Observable<Employee> {
    const url = `${this.baseUrl}/emp/employeeid/${id}`;
    return this.http.get<Employee>(url);
  }
  updatePendingStatus(obj:any){
    return (this.http.put('${this.baseUrl}/trans/payBill',obj,{
      responseType:'text'
    }));
  }

  addCustomerBillData(obj:any){
    return (this.http.post('${this.baseUrl}trans/addbillforcustomer',obj,{
      responseType:'text'
    }));

  }
  addCustomer(obj:any){
    return (this.http.post(`${this.baseUrl}/cus/addcustomer`,obj,{
      responseType:'text'
    }));
  }

  uploadCSVFile(file: File) {
    const formData = new FormData();
    formData.append('csvFile', file);

    return this.http.post(`${this.baseUrl}/cus/upload`, formData);
 
  }
  getTransactionData(){
  return (this.http.get(`${this.baseUrl}/trans/getTransactionData`))
  }

  
}
