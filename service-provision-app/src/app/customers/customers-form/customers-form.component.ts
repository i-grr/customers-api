import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';

@Component({
  selector: 'app-customers-form',
  templateUrl: './customers-form.component.html',
  styleUrls: ['./customers-form.component.css']
})
export class CustomersFormComponent implements OnInit {

  customer: Customer;

  constructor() {
    this.customer = new Customer();
   }

  ngOnInit(): void {
  }

  clicar() {
    console.log(this.customer);
  }

}
