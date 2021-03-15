package io.github.i_grr.serviceprovision.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.i_grr.serviceprovision.model.entity.ServiceProvided;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer> {

	@Query("SELECT s FROM ServiceProvided s join s.customer c "
			+ "WHERE UPPER(c.name) LIKE upper(:name) AND MONTH(s.date) =:month")
	List<ServiceProvided> findByCustomerNameAndMonth(@Param("name") String name, 
													 @Param("month") Integer month);
	
}
