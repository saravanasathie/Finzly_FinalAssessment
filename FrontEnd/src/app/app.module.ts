import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { ViewBillComponent } from './view-bill/view-bill.component';
import { TransactionTrackingComponent } from './transaction-tracking/transaction-tracking.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CustomerBillDataComponent } from './customer-bill-data/customer-bill-data.component';
import { AddCustomerManualComponent } from './add-customer-manual/add-customer-manual.component';
import { AddCustomerCSVComponent } from './add-customer-csv/add-customer-csv.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    ViewBillComponent,
    TransactionTrackingComponent,
    DashboardComponent,
    CustomerBillDataComponent,
    AddCustomerManualComponent,
    AddCustomerCSVComponent
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
