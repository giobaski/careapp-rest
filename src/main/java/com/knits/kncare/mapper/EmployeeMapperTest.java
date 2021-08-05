package com.knits.kncare.mapper;

import com.knits.kncare.dto.EmployeeDtoTest;
import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.Employee;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * For all the available features and annotations see:
 * https://mapstruct.org/documentation/stable/reference/html/
 */
@Mapper(componentModel="spring")
public interface EmployeeMapperTest extends MapperInterface<Employee, EmployeeDtoTest> {

    EmployeeMapperTest INSTANCE = Mappers.getMapper(EmployeeMapperTest.class);


    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    EmployeeDtoTest toDto(Employee model);

    @Override
    Employee toModel(EmployeeDtoTest dto);

    @Override
    List<EmployeeDtoTest> toDtoList(List<Employee> models);

}
