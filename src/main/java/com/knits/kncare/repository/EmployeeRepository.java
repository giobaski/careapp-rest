package com.knits.kncare.repository;

import com.knits.kncare.dto.EmployeeDtoTest;
import com.knits.kncare.model.ems.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByPdmId(Long pdmId);

}
