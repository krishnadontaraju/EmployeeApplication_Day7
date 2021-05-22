package com.employee.employeeapplication.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;

public @ToString class EmployeePayRollDTO {

	@Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$" , message = "Employee name not according to the pattern")
	public String name;

	@Min(value = 500 , message = "Wage cannot be less than 500")
	public long salary;

	@Pattern(regexp = "Male|Female|TransGender|Non-Straight" , message = "Gender can only be Male / Female / TransGender / Non-Straight")
	public String gender;

	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull (message = "Start Date cannot be left empty")
	@PastOrPresent(message = "Start Date cannot be newer than today's Date")
	public LocalDate startDate;

	@NotBlank(message = "Note cannot be empty")
	public String note;

	@NotBlank(message = "Employee must have a picture")
	public String picture;

	@NotNull(message = "Departments should be mentioned")
	public List<String> departments;
	
	
	public EmployeePayRollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

}
