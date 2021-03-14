import { Injectable } from '@angular/core';
import { Customer } from './customers/customer';
import { CustomersRoutingModule } from './customers/customers-routing.module';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor() { }

  getCustomer() : Customer {
    let customer: Customer = new Customer();
    customer.name = 'Igor';
    customer.cpf = '888';
    return customer;
  }

}
