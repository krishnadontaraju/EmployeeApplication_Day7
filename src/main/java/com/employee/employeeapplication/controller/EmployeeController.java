package com.employee.employeeapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeeapplication.dto.EmployeePayRollDTO;
import com.employee.employeeapplication.dto.ResponseDTO;
import com.employee.employeeapplication.model.EmployeePayRollData;
import com.employee.employeeapplication.service.IEmployeeService;

@RestController
@RequestMapping("/employeeservice")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeePayRollService;

    @RequestMapping(value ={"","/","/employee"})
    public ResponseEntity<ResponseDTO> getEmployeePayRollData(){
    	List<EmployeePayRollData> employeePayRollDataList = null;
    	employeePayRollDataList = employeePayRollService.getEmployeePayRollData();
    	ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , employeePayRollDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO ,HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayRollData(@PathVariable("empId") int empId){
    	EmployeePayRollData employeeData = null;
    	employeeData = employeePayRollService.getEmployeePayRollDataById(empId);
    	ResponseDTO responseDTO = new ResponseDTO("Get Call For Id Successful" , employeeData);
    	return new ResponseEntity<ResponseDTO>( responseDTO ,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayRollData(@RequestBody EmployeePayRollDTO employeePayRollDTO){
    	EmployeePayRollData employeeData = null;
    	employeeData = employeePayRollService.createEmployeePayRollData(employeePayRollDTO);
    	employeeData = new EmployeePayRollData(1, employeePayRollDTO);
    	ResponseDTO responseDTO = new ResponseDTO("Created Employee PayRoll Data Succesfully" , employeeData);
        return new ResponseEntity<ResponseDTO>( responseDTO , HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayRollData(@PathVariable("empId") int empId , @RequestBody EmployeePayRollDTO employeePayRollDTO){
    	EmployeePayRollData employeeData = null;
    	employeeData = employeePayRollService.updateEmployeePayRollData(empId, employeePayRollDTO);
    	employeeData = new EmployeePayRollData(1, employeePayRollDTO);
    	ResponseDTO responseDTO = new ResponseDTO("Updated Employee PayRoll Data Successfully" , employeeData);
        return new ResponseEntity<ResponseDTO>( responseDTO , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayRollData(@PathVariable("empId") int empId){
    	employeePayRollService.deleteEmployeePayRollData(empId);
    	ResponseDTO responseDTO = new ResponseDTO("Deleted successfully ","Deleted id"+empId);
        return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.OK);
    }

}
