package com.employee.employeeapplication;

import org.apache.catalina.core.ApplicationContext;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Slf4j
public class EmployeeApplication {

    public static void main(String[] args) {
        org.springframework.context.ApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
       
		log.info("Eploye Payroll App Started in {} Environment" , ((ConfigurableApplicationContext) context).getEnvironment().getProperty("environment"));
		
		log.info("Eploye Payroll App Started in {} Environment" , ((ConfigurableApplicationContext) context).getEnvironment().getProperty("spring.datasource.username"));
        
    }

}
