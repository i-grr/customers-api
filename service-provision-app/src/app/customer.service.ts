import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Customer } from './customers/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor( private http: HttpClient) { }

  getCustomer() : Customer {
    let customer: Customer = new Customer();
    customer.name = 'Igor';
    customer.cpf = '888';
    return customer;
  }

}
