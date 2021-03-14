package io.github.i_grr.customers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.i_grr.customers.model.entity.Customer;
import io.github.i_grr.customers.model.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer save(@RequestBody @Valid Customer customer) {
		System.out.println(customer.getName());
		System.out.println(customer.getCpf());
		return customerRepository.save(customer);
	}
	
	@GetMapping("{id}")
	public Customer findById(@PathVariable Integer id) {
		return customerRepository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Integer id) {
		customerRepository
			.findById(id)
			.map(customer -> {
				customerRepository.delete(customer);
				return Void.TYPE;
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id,
					   @RequestBody @Valid Customer customerUpdated) {
		customerRepository
			.findById(id)
			.map(customer -> {
				customerUpdated.setId(customer.getId());
				return customerRepository.save(customerUpdated);
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
}
