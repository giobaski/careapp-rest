package com.knits.kncare.service;

import com.knits.kncare.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {



    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


//    public List<EmployeeDtoTest> getAll(){
//        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"id"))
//                .stream()
//                .map(employee -> employeeMapperTest.toDto(employee))
//                .collect(Collectors.toList());
//    }
//
//
//    public Optional<EmployeeDtoTest> getById(Long id){
//        Optional<EmployeeDtoTest> employee = employeeRepository.findById(id)
//        .map(employeeMapperTest::toDto);
//        return employee;
//    }
}
