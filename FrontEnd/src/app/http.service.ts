import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private apiUrl ='http://localhost:8080/';

  constructor(private http: HttpClient) { }


  login(obj:any){
    let employeeId=+obj;
    return (this.http.post(`${this.apiUrl}emp/employeeid/${employeeId}`,null,{
      responseType:'text'
    }));
  }

  sendOTP(){
   return ( this.http.get(`${this.apiUrl}getOTP`,{
      responseType:'text'
    }))
  }

  getAllCustomerBillRecord(){
    return (this.http.get(`${this.apiUrl}trans/gettransaction`));
  }

  updatePendingStatus(obj:any){
    return (this.http.put(`${this.apiUrl}trans/addpending`,obj,{
      responseType:'text'
    }));
  }

  getAllCustomerData(){
    return (this.http.get(`${this.apiUrl}cus/getcus`))
  }

  addCustomerBillData(obj:any){
    return (this.http.post(`${this.apiUrl}trans/addbillforcustomer`,obj,{
      responseType:'text'
    }));

  }

  uploadCSVFile(file: File) {
    const formData = new FormData();
    formData.append('csvFile', file);

    return this.http.post(`${this.apiUrl}cus/upload`, formData);
  
 
  }


  getSpecificBillData(billid:any){
    let id=+billid;
    return (this.http.get(`${this.apiUrl}Bill-Payment/getById/${id}`))
}


 getInvoiceData(billid:any){
  let id=+billid;
  return(this.http.get(`${this.apiUrl}invoice/getInvoiceInfo/${id}`));
}

  getPaymentTrakingData(){
    return (this.http.get(`${this.apiUrl}getAllPaymentDetails`))


}

 



}