package com.knits.kncare.service;

import com.knits.kncare.dto.AbstractSearchableDto;
import com.knits.kncare.dto.EmployeeDto;
import com.knits.kncare.mapper.MapperInterface;
import com.knits.kncare.model.ems.Employee;
import com.knits.kncare.repository.EmployeeRepository;
import com.knits.kncare.utils.Specifications;
import net.minidev.json.annotate.JsonIgnore;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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

    public Page<EmployeeDto> search(EmployeeDto employeeDto) {
        Employee employee = toModel(employeeDto);
        Specification<Employee> spec = super.getSpecification();

        return toDtoPage(repository.findAll(getSpecification(spec, employeeDto), employee.getPageable()));
    }

    public static Specification<Employee> getSpecification(Specification<Employee> spec, EmployeeDto employeeDto) {
        if (Strings.isNotBlank(employeeDto.getFirstName())){
            spec = spec.and(Specifications.specLike("firstName", "%" + employeeDto.getFirstName() + "%")) ;
        }
        if (Strings.isNotBlank(employeeDto.getLastName())){
            spec = spec.and(Specifications.specLike("lastName", "%" + employeeDto.getLastName() + "%")) ;
        }
        if (Strings.isNotBlank(employeeDto.getInternationalName())){
            spec = spec.and(Specifications.specLike("internationalName", "%" + employeeDto.getInternationalName() + "%")) ;
        }
        if (Strings.isNotBlank(employeeDto.getTitle())){
            spec = spec.and(Specifications.specLike("title", "%" + employeeDto.getTitle() + "%")) ;
        }
        if (employeeDto.getNationality() != null){
            spec = spec.and(Specifications.specEquals("nationality", employeeDto.getNationality().getId()));
        }
        if (employeeDto.getBusinessUnit() != null){
            spec = spec.and(Specifications.specEquals("businessUnit", employeeDto.getBusinessUnit().getId()));
        }


        return spec;
    }
}
