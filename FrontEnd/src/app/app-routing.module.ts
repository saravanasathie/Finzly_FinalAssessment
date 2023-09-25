import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CustomerBillDataComponent } from './customer-bill-data/customer-bill-data.component';
import { AddCustomerCSVComponent } from './add-customer-csv/add-customer-csv.component';
import { AddCustomerManualComponent } from './add-customer-manual/add-customer-manual.component';
import { ViewBillComponent } from './view-bill/view-bill.component';
import { TransactionTrackingComponent } from './transaction-tracking/transaction-tracking.component';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent},
  {path:"",redirectTo:"/login",pathMatch:"full"},
  {path:"login",component:LoginComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'customer-bill-data',component:CustomerBillDataComponent},
  {path:'add-customer-manual',component:AddCustomerManualComponent},
  {path:'add-customer-csv',component:AddCustomerCSVComponent},
  {path:'viewbill/:id',component:ViewBillComponent},
  {path:'transaction-tracking',component:TransactionTrackingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
