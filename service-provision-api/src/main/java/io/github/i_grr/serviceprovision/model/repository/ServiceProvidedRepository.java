package io.github.i_grr.serviceprovision.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.i_grr.serviceprovision.model.entity.ServiceProvided;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer> {

}
