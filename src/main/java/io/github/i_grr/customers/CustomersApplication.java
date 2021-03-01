package io.github.i_grr.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.i_grr.customers.model.entity.Customer;
import io.github.i_grr.customers.model.repository.CustomerRepository;

@SpringBootApplication
public class CustomersApplication {
	
	@Bean
	public CommandLineRunner run(@Autowired CustomerRepository customerRepository) {
		return args -> {
			Customer customer = Customer.builder().cpf("51974530876").name("Fulano").build();
			customerRepository.save(customer);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class, args);
	}

}
