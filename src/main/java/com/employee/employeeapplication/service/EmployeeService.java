package com.employee.employeeapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.employeeapplication.dto.EmployeePayRollDTO;
import com.employee.employeeapplication.exception.EmployeeServiceException;
import com.employee.employeeapplication.model.EmployeePayRollData;

@Service
public class EmployeeService  implements IEmployeeService{
	
	private List<EmployeePayRollData> employeePayRollDataList =  new ArrayList<>();

	@Override
	public List<EmployeePayRollData> getEmployeePayRollData() {
		
		return employeePayRollDataList;
	}

	@Override
	public EmployeePayRollData getEmployeePayRollDataById(int employeeId) {
		return employeePayRollDataList.stream()
										.filter(employee -> employee.getEmployeeId() == employeeId)
										.findFirst()
										.orElseThrow(() -> new EmployeeServiceException("Employe with your ID not found"));
	}

	@Override
	public EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData employeePayRollData = null;
		employeePayRollData = new EmployeePayRollData(employeePayRollDataList.size() + 1 , employeePayRollDTO);
		employeePayRollDataList.add(employeePayRollData);
		return employeePayRollData;
	}

	@Override
	public EmployeePayRollData updateEmployeePayRollData(int employeeId, EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData employeePayRollData = this.getEmployeePayRollDataById(employeeId);
		employeePayRollData.setName(employeePayRollDTO.name);
		employeePayRollData.setSalary(employeePayRollDTO.salary);
		
		employeePayRollDataList.set(employeeId - 1 , employeePayRollData);

		return employeePayRollData;
	}

	@Override
	public void deleteEmployeePayRollData(int employeeid) {}

}
