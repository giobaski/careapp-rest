package com.knits.kncare.service;

import com.knits.kncare.dto.EmployeeDto;
import com.knits.kncare.dto.EmployeePage;
import com.knits.kncare.dto.EmployeeSearch;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService extends ServiceBase<Employee, EmployeeDto> {

    @Autowired
    private WebClient webClient;


    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository, MapperInterface<Employee, EmployeeDto> mapper) {
        super(mapper);
        this.repository = repository;
    }

    public List<Employee> getAll() { return repository.findAll(); }

    public Optional<Employee> getById(long id) {
        return repository.findById(id);
    }

    public Employee Add(Employee employee) {
        return repository.save(employee);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    public void deleteAll(){
        repository.deleteAll();
    }

    public Page<EmployeeDto> searchByFields(EmployeeSearch employeeSearch) {
//        Specification<Employee> spec = super.getSpecification();
//        Employee employee = new Employee();
//        return toDtoPage(repository.findAll(employeeSearch.search(spec, employeeSearch),employee.getPageable()));

        EmployeePage employeePage = webClient
                .post()
                .uri("/employees")
                .body(Mono.just(employeeSearch), EmployeeSearch.class)
                .retrieve()
                .bodyToMono(EmployeePage.class)
                .block();

        return employeePage != null ? new PageImpl<>(employeePage.getContent()) : null;
    }




}
