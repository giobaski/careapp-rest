package com.knits.kncare.service;

import com.knits.kncare.dto.EmployeeDto;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService extends ServiceBase<Employee, EmployeeDto>{
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

    public Page<EmployeeDto> search(EmployeeDto employeeDto) {
        Employee employee = toModel(employeeDto);
        return toDtoPage(repository.findAll(employee.getSpecification(), employee.getPageable()));
    }
}
