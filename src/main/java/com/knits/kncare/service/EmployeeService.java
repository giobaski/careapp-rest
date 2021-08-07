package com.knits.kncare.service;

import com.knits.kncare.dto.EmployeeDto;
import com.knits.kncare.dto.EmployeeSearch;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService extends ServiceBase<Employee, EmployeeDto> {
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

    // I tried to move it to repository but the repo failed to initialize
    public Page<EmployeeDto> searchByFields(EmployeeSearch employeeSearch) {
        Specification<Employee> spec = super.getSpecification();
        Employee employee = new Employee();
        return toDtoPage(repository.findAll(employeeSearch.search(spec, employeeSearch),employee.getPageable()));
    }




}
