package com.knits.kncare.mapper;

import com.knits.kncare.dto.BusinessUnitDto;
import com.knits.kncare.model.ems.BusinessUnit;
import org.mapstruct.Mapper;


/**
 * For all the available features and annotations see:
 * https://mapstruct.org/documentation/stable/reference/html/
 */
@Mapper(componentModel = "spring")
public interface BusinessUnitMapper extends MapperInterface<BusinessUnit, BusinessUnitDto> {

}
