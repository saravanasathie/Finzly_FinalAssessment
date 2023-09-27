import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CustomerComponent } from './customer/customer.component';
import { HomeComponent } from './home/home.component';
import { AddCustomerManualComponent } from './add-customer-manual/add-customer-manual.component';
import { AddCustomerCsvComponent } from './add-customer-csv/add-customer-csv.component';
import { UnpaidbillsComponent } from './unpaidbills/unpaidbills.component';
import { PaidbillsComponent } from './paidbills/paidbills.component';
import { AddBillComponent } from './add-bill/add-bill.component';
import { TransactionTrackingComponent } from './transaction-tracking/transaction-tracking.component';
import { InvoiceComponent } from './invoice/invoice.component';


const routes: Routes = [

{
  path:"" , component:LoginComponent
},
{
  path:'home', component:HomeComponent
},
{
  path:'customer-data', component: CustomerComponent
},
{
  path:'add-customer-manual',component:AddCustomerManualComponent
},
{
  path:'add-customer-csv',component:AddCustomerCsvComponent
},
{
  path:'unpaidbills', component:UnpaidbillsComponent
},
{
  path:'paidbills', component:PaidbillsComponent
},
{
  path:'add-bill', component:AddBillComponent
},
{
  path:'transaction-tracking',component:TransactionTrackingComponent
},
{
  path:'invoice',component:InvoiceComponent
}

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
