
import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  implements OnInit{

  Cid!: number;
  OTP!: number;
  random!: number;

  min = 100000;
  max = 999999;

  showOTPInput: boolean=false;
  isOTPValid: boolean = false;

  constructor(private http:EmployeeService, private empService:EmployeeService, private router:Router) { }


  ngOnInit(): void {
    
    this.getTransaction();
    this.onSubmit();
    
  }
  

  getTransaction(){
    this.http.getallBill().subscribe(response=>{
      console.log(response);      
    });
  }
  generateOTP(){
    let randomInteger = Math.floor(Math.random()* (this.max - this.min + 1)) + this.min;
    console.log(randomInteger);
    this.random = randomInteger;
    alert(randomInteger);
    this.showOTPInput = true;
    this.isOTPValid = true ;
  }

  
  onSubmit() {
    
    return this.empService.getEmployeeById(this.Cid).subscribe(
      (response) => {
        if(this.OTP== this.random){
          console.log('Login successful');
          console.log(this.Cid);
          sessionStorage.setItem("customerId",""+this.Cid);
          console.log('API Response:', response);
          this.router.navigate(['./home']);
        }else{
          alert(`Invalid Otp and Customer Id`);
          window.location.reload();
        }
        
      }
  );
}
}


