package com.employee.employeeapplication.service;

import java.util.List;

import com.employee.employeeapplication.dto.EmployeePayRollDTO;
import com.employee.employeeapplication.model.EmployeePayRollData;

public interface IEmployeeService {

	List<EmployeePayRollData> getEmployeePayRollData();
	
	EmployeePayRollData getEmployeePayRollDataById(int employeeId);
	
	EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO);
	
	void deleteEmployeePayRollData(int employeeid);

	EmployeePayRollData updateEmployeePayRollData(int employeeId, EmployeePayRollDTO employeePayRollDTO);
}
