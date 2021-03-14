import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-customers-form',
  templateUrl: './customers-form.component.html',
  styleUrls: ['./customers-form.component.css']
})
export class CustomersFormComponent implements OnInit {

  customer: Customer;

  constructor(private service: CustomerService) {
    this.customer = service.getCustomer();
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.customer);
  }

}
