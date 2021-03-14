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
  success: boolean = false;
  errors: String[];

  constructor(private service: CustomerService) {
    this.customer = new Customer();
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service
      .save(this.customer)
      .subscribe(response => {
        this.success = true;
      }, errorResponse => {
        this.errors = errorResponse.error.errors;
      })
  }

}
