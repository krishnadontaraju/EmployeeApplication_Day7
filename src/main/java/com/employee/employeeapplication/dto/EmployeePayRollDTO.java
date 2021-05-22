package com.employee.employeeapplication.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

public @ToString class EmployeePayRollDTO {

	public String name;
	public long salary;
	public String gender;

	@JsonFormat(pattern = "dd MMM yyyy")
	public LocalDate startDate;
	public String note;
	public String picture;
	public List<String> departments;
	
	
	public EmployeePayRollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

}
