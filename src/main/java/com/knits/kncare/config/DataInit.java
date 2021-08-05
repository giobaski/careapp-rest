package com.knits.kncare.config;

import com.knits.kncare.model.ems.Country;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class DataInit {
//    @Bean
//    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
//        Country country = new Country();
//        country.setName("France");
//        Employee employee = new Employee();
//        employee.setInternationalName("John Test");
//        employee.setNationality(country);
//        return args -> {
//            repository.save(employee);
//        };
//    }
}