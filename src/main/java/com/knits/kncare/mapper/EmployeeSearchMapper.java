package com.knits.kncare.mapper;

import com.knits.kncare.dto.EmployeeDto;
import com.knits.kncare.dto.EmployeeSearch;
import com.knits.kncare.model.ems.Employee;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface EmployeeSearchMapper extends MapperInterface<Employee, EmployeeSearch>{
    EmployeeSearchMapper INSTANCE = Mappers.getMapper(EmployeeSearchMapper.class);


    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    EmployeeSearch toDto(Employee model);

    @Override
    Employee toModel(EmployeeSearch employeeSearch);

    @Override
    List<EmployeeSearch> toDtoList(List<Employee> models);
}
