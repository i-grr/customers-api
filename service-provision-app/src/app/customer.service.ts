import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Customer } from './customers/customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor( private http: HttpClient) { }

  save(customer : Customer) : Observable<Customer> {
    return this.http.post<Customer>('http://localhost:8080/api/customers/', customer);
  }

  /*
  getCustomers() : Observable<Customer[]> {
    return ;
  }*/

  getCustomers() : Customer[] {
    let customer = new Customer();
    customer.id = 1;
    customer.name = 'Igor';
    customer.registerDate = '10/03/2021';
    customer.cpf = '123123';
    return [customer];
  }

}
