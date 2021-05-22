package com.employee.employeeapplication.service;

import java.util.ArrayList;
import java.util.List;

import com.employee.employeeapplication.repository.EmployeePayRollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeeapplication.dto.EmployeePayRollDTO;
import com.employee.employeeapplication.exception.EmployeeServiceException;
import com.employee.employeeapplication.model.EmployeePayRollData;

@Service
@Slf4j
public class EmployeeService  implements IEmployeeService{

	@Autowired
	private EmployeePayRollRepository employeePayRollRepository;
	
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
		employeePayRollData = new EmployeePayRollData(employeePayRollDTO);
		employeePayRollDataList.add(employeePayRollData);
		log.debug("Employee Data : "+employeePayRollData.toString());
		return employeePayRollRepository.save(employeePayRollData);
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
