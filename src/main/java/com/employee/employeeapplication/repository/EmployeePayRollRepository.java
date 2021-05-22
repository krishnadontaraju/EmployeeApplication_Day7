package com.employee.employeeapplication.repository;

import com.employee.employeeapplication.model.EmployeePayRollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayRollRepository extends JpaRepository<EmployeePayRollData , Integer> {
    @Query(value = "SELECT * FROM payroll_operations , department WHERE employee_id = =id AND department = :department" ,nativeQuery = true)
    List<EmployeePayRollData> findEmployeesByDepartment(String department);
}
