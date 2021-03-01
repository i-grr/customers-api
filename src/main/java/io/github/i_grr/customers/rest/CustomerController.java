package io.github.i_grr.customers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.i_grr.customers.model.entity.Customer;
import io.github.i_grr.customers.model.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer save(@RequestBody Customer customer) {
		System.out.println(customer.getName());
		System.out.println(customer.getCpf());
		return customerRepository.save(customer);
	}
	
	@GetMapping("{id}")
	public Customer findById(@PathVariable Integer id) {
		return customerRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}
