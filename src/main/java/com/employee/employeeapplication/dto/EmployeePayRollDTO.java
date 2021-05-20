package com.employee.employeeapplication.dto;

public class EmployeePayRollDTO {

	public String name;
	public long salary;
	
	
	public EmployeePayRollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "name=" + name + ", salary=" + salary;
	}
	
}
