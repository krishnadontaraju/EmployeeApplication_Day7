package com.employee.employeeapplication.model;

import com.employee.employeeapplication.dto.EmployeePayRollDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="payroll_information")
public @Data class EmployeePayRollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name="name")
	private String name;

	@Column(name = "salary")
	private long salary;

	@Column(name = "gender")
	private String gender;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "note")
	private String note;

	@Column(name = "picture")
	private String picture;

	@ElementCollection
	@CollectionTable(name ="employee_deartment" , joinColumns = @JoinColumn(name="id"))
	@Column(name = "department")
	private List<String> departments;
	
	public EmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
		this.updateEmployeePayRollData(employeePayRollDTO);

	}

	public void updateEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO){
		this.name = employeePayRollDTO.name;
		this.salary = employeePayRollDTO.salary;
		this.gender = employeePayRollDTO.gender;
		this.startDate = employeePayRollDTO.startDate;
		this.note = employeePayRollDTO.note;
		this.picture = employeePayRollDTO.picture;
		this.departments = employeePayRollDTO.departments;
	}

	public EmployeePayRollData() {}

}
