import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CustomerComponent } from './customer/customer.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { AddCustomerManualComponent } from './add-customer-manual/add-customer-manual.component';
import { AddCustomerCsvComponent } from './add-customer-csv/add-customer-csv.component';
import { AddBillComponent } from './add-bill/add-bill.component';
import { PaidbillsComponent } from './paidbills/paidbills.component';
import { UnpaidbillsComponent } from './unpaidbills/unpaidbills.component';
import { TransactionTrackingComponent } from './transaction-tracking/transaction-tracking.component';
import { InvoiceComponent } from './invoice/invoice.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CustomerComponent,
    HomeComponent,
    HeaderComponent,
    AddCustomerManualComponent,
    AddCustomerCsvComponent,
    AddBillComponent,
    PaidbillsComponent,
    UnpaidbillsComponent,
    TransactionTrackingComponent,
    InvoiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
