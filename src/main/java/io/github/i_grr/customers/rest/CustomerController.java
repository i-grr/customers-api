package io.github.i_grr.customers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.i_grr.customers.model.entity.Customer;
import io.github.i_grr.customers.model.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
}
