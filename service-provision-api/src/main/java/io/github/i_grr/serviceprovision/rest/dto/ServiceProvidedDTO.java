package io.github.i_grr.serviceprovision.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceProvidedDTO {
	
	private String description;
	private String price;
	private String date;
	private Integer customerId;

}
