package com.knits.kncare.service;

import com.knits.kncare.dto.EmployeeDto;
import com.knits.kncare.dto.pages.EmployeeDtoPage;
import com.knits.kncare.dto.search.EmployeeSearchDto;
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

    private final String emsSearchUrl = "/employees/search";

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

    public Page<EmployeeDto> search(EmployeeSearchDto employeeSearch) {

        EmployeeDtoPage employeePage = webClient
                .post()
                .uri(emsSearchUrl)
                .body(Mono.just(employeeSearch), EmployeeSearchDto.class)
                .retrieve()
                .bodyToMono(EmployeeDtoPage.class)
                .block();

        if (employeePage!=null && employeePage.getEmployees().size()>0){
            updateLocalEmployeesStorage(employeePage);
        }

        return new PageImpl<>(employeePage.getEmployees(), employeeSearch.getPageable(), employeePage.getEmployees().size());
    }


        private void updateLocalEmployeesStorage(EmployeeDtoPage employeePage){

            for (EmployeeDto employeeDto:employeePage.getEmployees()) {
                Optional<Employee> employeeAsOpt = repository.findByPdmId(employeeDto.getPdmId());
                if (employeeAsOpt.isEmpty()){
                    repository.save(toModel(employeeDto));
                }
            }
        }


}
