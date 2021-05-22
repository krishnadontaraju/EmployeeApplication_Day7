package com.employee.employeeapplication.repository;

import com.employee.employeeapplication.model.EmployeePayRollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayRollRepository extends JpaRepository<EmployeePayRollData , Integer> {
}
