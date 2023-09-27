import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  showDropdown=true;
  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  navigateToPaidBills(event:Event):void{
    const selectedOption=(event.target as HTMLSelectElement).value;
    switch(selectedOption){
      case 'paid':
        this.router.navigate(["paidbills"]);
        break;
        case 'unpaid':
          this.router.navigate(['/unpaidbills']);
          break;
          default:
            break;
    }
  }

//   navigateToPaidBills(selectedOption: string, event: Event): void {
//     event.preventDefault(); // Prevent the default behavior of the anchor tag
//     switch (selectedOption) {
//         case 'paid':
//             this.router.navigate(["/paidbills"]);
//             break;
//         case 'unpaid':
//             this.router.navigate(['/unpaidbills']);
//             break;
//         default:
//             break;
//     }
// }
navigateToCustomerBill(){
  this.router.navigate(['/customer-data']);
}
navigateToTransactionTracking(){
  this.router.navigate(['/transaction-tracking']);
}
}
