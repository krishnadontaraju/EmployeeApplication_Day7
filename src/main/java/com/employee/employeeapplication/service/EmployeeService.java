package com.employee.employeeapplication.service;

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

	@Override
	public List<EmployeePayRollData> getEmployeePayRollData() {
		
		return employeePayRollRepository.findAll();
	}

	@Override
	public EmployeePayRollData getEmployeePayRollDataById(int employeeId) {
		return employeePayRollRepository.findById(employeeId)
										.orElseThrow(() -> new EmployeeServiceException("Employee with your ID not found"));
	}

	@Override
	public EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData employeePayRollData = null;
		employeePayRollData = new EmployeePayRollData(employeePayRollDTO);
		log.debug("Employee Data : "+ employeePayRollData);
		return employeePayRollRepository.save(employeePayRollData);
	}

	@Override
	public EmployeePayRollData updateEmployeePayRollData(int employeeId, EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData employeePayRollData = this.getEmployeePayRollDataById(employeeId);
		employeePayRollData.updateEmployeePayRollData(employeePayRollDTO);

		return employeePayRollRepository.save(employeePayRollData);
	}

	@Override
	public List<EmployeePayRollData> getEmployeesByDepartment(String department) {
		return employeePayRollRepository.findEmployeesByDepartment(department);
	}

	@Override
	public void deleteEmployeePayRollData(int employeeid) {
		EmployeePayRollData employeePayRollData = this.getEmployeePayRollDataById(employeeid);
		employeePayRollRepository.delete(employeePayRollData);
	}

}
