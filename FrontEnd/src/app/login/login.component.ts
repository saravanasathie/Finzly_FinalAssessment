import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpService } from '../http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit,OnDestroy {
  idPattern !: number;
  otp:string='';
  msg:string="";
  isotpsend:boolean=true;
 
  constructor(private service:HttpService,
    private router:Router) { }

  ngOnInit(): void {
    document.body.className="background";
  }

  onSubmit(f:NgForm){
    
    let employeeId=f.value.employeeId;
    this.router.navigate(['/dashboard']);

    // let userotp=f.value.otp;
    // console.log(employeeId)
    // console.log(userotp)
    // this.service.login(employeeId)
    // .subscribe((response:any)=>{
    //   console.log(response);
    //   console.log(this.otp);
    //   console.log(userotp);
    //   if(response==="Valid User" && this.otp===userotp){
    //     alert(response)
    //     // navigate to dashboard
    //     sessionStorage.setItem("employeeId",employeeId);
    //     this.router.navigate(['/dashboard']);
    //   }else{
    //     alert("InValid user")
    //   }
    // })

  }
  sendOTP(){
    this.service.sendOTP().subscribe((response)=>{
      this.otp=response;
      alert(`Your otp is ${response}`);
    })
    this.isotpsend=true;
  }
  ngOnDestroy(): void {
    document.body.className=" ";
  }
  

}