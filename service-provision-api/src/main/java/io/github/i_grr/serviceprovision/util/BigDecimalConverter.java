package io.github.i_grr.serviceprovision.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class BigDecimalConverter {

	public BigDecimal converter(String value) {
		
		if (value == null)
			return null;
		else
			return new BigDecimal(value.replace(".", "").replace(",", "."));
		
	}
	
}
