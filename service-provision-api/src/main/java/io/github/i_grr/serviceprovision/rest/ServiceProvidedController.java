package io.github.i_grr.serviceprovision.rest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.i_grr.serviceprovision.model.entity.Customer;
import io.github.i_grr.serviceprovision.model.entity.ServiceProvided;
import io.github.i_grr.serviceprovision.model.repository.CustomerRepository;
import io.github.i_grr.serviceprovision.model.repository.ServiceProvidedRepository;
import io.github.i_grr.serviceprovision.rest.dto.ServiceProvidedDTO;
import io.github.i_grr.serviceprovision.util.BigDecimalConverter;

@RestController
@RequestMapping("/api/services-provided")
public class ServiceProvidedController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ServiceProvidedRepository serviceProvidedRepository;
	
	@Autowired
	private BigDecimalConverter bigDecimalConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceProvided save(@RequestBody ServiceProvidedDTO dto) {	
		
		LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer customerId = dto.getCustomerId();
		
		Customer customer = customerRepository
								.findById(customerId)
								.orElseThrow(() -> new ResponseStatusException(
										HttpStatus.BAD_REQUEST, "Cliente inexistente."
								));			
		
		ServiceProvided serviceProvided = new ServiceProvided();
		serviceProvided.setDescription(dto.getDescription());
		serviceProvided
			.setDate(date);
		serviceProvided.setCustomer(customer);
		serviceProvided.setValue(bigDecimalConverter.converter(dto.getPrice()));
		
		return serviceProvidedRepository.save(serviceProvided);
		
	}
	
}
