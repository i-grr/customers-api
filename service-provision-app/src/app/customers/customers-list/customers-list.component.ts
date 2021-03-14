import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {

  customers: Customer[] = [];

  constructor(
    private service: CustomerService, 
    private router: Router) { }

  ngOnInit(): void {
    this.service
      .getCustomers()
      .subscribe(response => this.customers = response);
  }

  newRegister() {
    this.router.navigate(['/customers-form']);
  }

}
