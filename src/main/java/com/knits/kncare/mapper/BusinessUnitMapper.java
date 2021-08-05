package com.knits.kncare.mapper;

import com.knits.kncare.dto.BusinessUnitDto;
import com.knits.kncare.dto.EmployeeDtoTest;
import com.knits.kncare.model.ems.BusinessUnit;
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
public interface BusinessUnitMapper extends MapperInterface<BusinessUnit, BusinessUnitDto> {

    BusinessUnitMapper INSTANCE = Mappers.getMapper(BusinessUnitMapper.class);


    @Override
    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    BusinessUnitDto toDto(BusinessUnit model);

    @Override
    BusinessUnit toModel(BusinessUnitDto dto);

    @Override
    List<BusinessUnitDto> toDtoList(List<BusinessUnit> models);

}
