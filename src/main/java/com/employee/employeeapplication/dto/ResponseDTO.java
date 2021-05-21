package com.employee.employeeapplication.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class ResponseDTO {
	
	@NotEmpty(message = "Employee name cannot be null")
	@Pattern(regexp = "^[A-z]{1}[a-zA-z\\s]{2,}$",message = "Name is not according to the pattern , must have First letterr cap and mini of 3 letters")
	private String name;
	
	@Min(value = 500 , message = "Minimum salary must 500")
	private Object data;

	public ResponseDTO(String name, Object data) {
		this.name = name;
		this.data = data;
	}

}
