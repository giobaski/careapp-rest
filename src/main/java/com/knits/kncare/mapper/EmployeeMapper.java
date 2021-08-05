package com.knits.kncare.mapper;

import com.knits.kncare.dto.EmployeeDto;
import com.knits.kncare.dto.MemberDto;
import com.knits.kncare.model.Member;
import com.knits.kncare.model.ems.Employee;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface EmployeeMapper extends MapperInterface<Employee, EmployeeDto>{
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    EmployeeDto toDto(Employee model);

    @Override
    Employee toModel(EmployeeDto memberDto);

    @Override
    List<EmployeeDto> toDtoList(List<Employee> models);
}
