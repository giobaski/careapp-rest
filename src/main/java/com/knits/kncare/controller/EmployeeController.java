package com.knits.kncare.controller;

import com.knits.kncare.dto.EmployeeDto;
import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.service.EmployeeService;
import com.knits.kncare.service.MemberService;
import com.knits.kncare.service.ServiceBase;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/employee")
@RestController
public class EmployeeController{
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        Optional<Employee> memberData = service.getById(id);
        return memberData.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            return new ResponseEntity<>(service.Add(employee), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateUser(@PathVariable("id") long id, @RequestBody Employee employee) {
        Optional<Employee> memberData = service.getById(id);

        if (memberData.isPresent()) {
            return new ResponseEntity<>(service.Add(employee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        try {
            service.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping
//    @JsonView(Views.Public.class)
    public Page<EmployeeDto> searchMembers(EmployeeDto employeeDto) {
        return service.search(employeeDto);
    }
}
