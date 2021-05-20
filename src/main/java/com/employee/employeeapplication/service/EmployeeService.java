package com.employee.employeeapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.employeeapplication.dto.EmployeePayRollDTO;
import com.employee.employeeapplication.model.EmployeePayRollData;

@Service
public class EmployeeService  implements IEmployeeService{

	@Override
	public List<EmployeePayRollData> getEmployeePayRollData() {
		List<EmployeePayRollData> employeeDataList = new ArrayList<>();
		employeeDataList.add(new EmployeePayRollData(1, new EmployeePayRollDTO("Galfauger", 40000)));
		
		return employeeDataList;
	}

	@Override
	public EmployeePayRollData getEmployeePayRollDataById(int employeeId) {
		EmployeePayRollData employeePayRollData = null;
		employeePayRollData = new EmployeePayRollData(1, new EmployeePayRollDTO("Galfauger", 40000));
		return employeePayRollData;
	}

	@Override
	public EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData employeePayRollData = null;
		employeePayRollData = new EmployeePayRollData(1, employeePayRollDTO);
		return employeePayRollData;
	}

	@Override
	public EmployeePayRollData updateEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData employeePayRollData = null;
		employeePayRollData = new EmployeePayRollData(1, employeePayRollDTO);
		return employeePayRollData;
	}

	@Override
	public void deleteEmployeePayRollData(int employeeid) {}

}
