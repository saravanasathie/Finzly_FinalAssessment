import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { CustomerData } from "../customer-data";


@Component({
  selector: 'app-add-customer-csv',
  templateUrl: './add-customer-csv.component.html',
  styleUrls: ['./add-customer-csv.component.css']
})
export class AddCustomerCsvComponent implements OnInit {
  selectedFile: File | null = null;


  constructor(private service: EmployeeService,private router:Router) { }

  ngOnInit(): void {
  }
  uploadCSV() {
    if (this.selectedFile) {
      console.log(this.selectedFile)
      const formData = new FormData();
      formData.append('csvFile', this.selectedFile);
  
      this.service.uploadCSVFile(this.selectedFile)
        .subscribe((response) => {
          this.router.navigate(['/customer-data']);
          console.log(response);
          
          
        });
    } else {
      //this.toaster.error("No file selected");
      console.log("Error");
    }
  }

  onFileSelected(event:any){
    event.target.files[0];
    this.selectedFile=event.target.files[0];
    console.log(this.selectedFile);


  }
  
}

