package io.github.i_grr.customers.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.i_grr.customers.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
