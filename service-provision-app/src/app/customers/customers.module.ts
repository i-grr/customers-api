import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomersRoutingModule } from './customers-routing.module';
import { CustomersFormComponent } from './customers-form/customers-form.component';
import { FormsModule } from '@angular/forms';
import { CustomersListComponent } from './customers-list/customers-list.component';


@NgModule({
  declarations: [CustomersFormComponent, CustomersListComponent],
  imports: [
    CommonModule,
    CustomersRoutingModule,
    FormsModule
  ], exports: [
    CustomersFormComponent,
    CustomersListComponent
  ]
})
export class CustomersModule { }
