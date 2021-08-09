package com.knits.kncare.service;

import com.knits.kncare.dto.EmployeeDtoTest;
import com.knits.kncare.mapper.EmployeeMapperTest;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeMapperTest employeeMapperTest;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapperTest employeeMapperTest) {
        this.employeeRepository = employeeRepository;
        this.employeeMapperTest = employeeMapperTest;
    }


    public List<EmployeeDtoTest> getAll(){
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"id"))
                .stream()
                .map(employee -> employeeMapperTest.toDto(employee))
                .collect(Collectors.toList());
    }


    public Optional<EmployeeDtoTest> getById(Long id){
        Optional<EmployeeDtoTest> employee = employeeRepository.findById(id)
        .map(employeeMapperTest::toDto);
        return employee;
    }
}
