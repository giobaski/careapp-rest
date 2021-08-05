package com.knits.kncare.controller;

import com.knits.kncare.dto.EmployeeDtoTest;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequestMapping("/api/v1/employees")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping()
    public ResponseEntity<List<EmployeeDtoTest>> getAllEmployees(){
        try{
            List<EmployeeDtoTest> employees = new ArrayList<>();
            employeeService.getAll().forEach(employees::add);

            if(employees.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("{id}")
//    public ResponseEntity<EmployeeDtoTest> getEmployeeById(@PathVariable("id") Long id){
//        Optional<EmployeeDtoTest> employee = employeeService.getById(id);
//        if(employee.isPresent()){
//            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
//        } else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

}
