package com.employee.employeeapplication.controller;

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

@RestController
public class EmployeeController {

    @RequestMapping("/employee")
    public ResponseEntity<String> getEmployeePayRollData(){
        return new ResponseEntity<>("Get call is succesful ",HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayRollData(@PathVariable("empId") int empId){
    return new ResponseEntity<>("Get call is succesful for id "+empId,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayRollData(@RequestBody EmployeePayRollDTO employeePayRollDTO){
        return new ResponseEntity<>("Added the pay roll Data : "+employeePayRollDTO , HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayRollData(@RequestBody EmployeePayRollDTO employeePayRollDTO){
        return new ResponseEntity<>("Update the employee's Pay Roll data : "+employeePayRollDTO , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayRollData(@PathVariable("empId") int empId){
        return new ResponseEntity<>("Deleted employee's Data for id : "+empId , HttpStatus.OK);
    }

}
