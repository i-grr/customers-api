import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerService } from './customer.service';
import { CustomersModule } from './customers/customers.module';
import { HomeComponent } from './home/home.component';
import { TemplateModule } from './template/template.module';
import { ServiceProvidedModule } from './service-provided/service-provided.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    TemplateModule,
    CustomersModule,
    ServiceProvidedModule
  ],
  providers: [
    CustomerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
