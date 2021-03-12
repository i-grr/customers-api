package io.github.i_grr.customers.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 150)
	@NotEmpty(message = "{input.name.required}")
	private String name;
	
	@Column(nullable = false, length = 11)
	@NotNull(message = "{input.cpf.required}")
	@CPF(message = "{input.cpf.invalid}")
	private String cpf;
	
	@Column(name = "date_register", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateRegister;
	
	@PrePersist
	public void prePersist() {
		setDateRegister(LocalDate.now());
	}

}
