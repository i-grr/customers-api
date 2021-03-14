import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
  id: number;

  constructor(
    private service: CustomerService, 
    private router: Router,
    private activatedRoute: ActivatedRoute) {
      this.customer = new Customer();
  }

  ngOnInit(): void {
    let params = this.activatedRoute.params
      .subscribe(params => {

        if (params && params['id']) {
          this.service.getCustomerById(params.id)
            .subscribe(
              response => this.customer = response,
              errorResponse => this.customer = new Customer()
            )
        }
      });
  }

  onSubmit() {
    this.service
      .save(this.customer)
      .subscribe(response => {
        this.success = true;
        this.errors = [];
        this.customer = response;
      }, errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;
      })
  }

  backToListing() {
    this.router.navigate(['/customers-list']);
  }

}
