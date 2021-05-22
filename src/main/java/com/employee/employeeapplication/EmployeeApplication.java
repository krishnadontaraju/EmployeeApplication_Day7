package com.employee.employeeapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Slf4j
public class EmployeeApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
       
		log.info("Employee Payroll App Started in {} Environment" , context.getEnvironment().getProperty("environment"));
		
		log.info("Employee Payroll App Database User is {}" , context.getEnvironment().getProperty("spring.datasource.username"));
        
    }

}
