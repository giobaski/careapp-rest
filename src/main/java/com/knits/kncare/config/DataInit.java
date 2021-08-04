package com.knits.kncare.config;

import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInit {
    private final String name = "Siim Toomingas";
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        Employee employee = new Employee();
        return args -> {
            repository.save(employee);
        };
    }
}