package com.knits.kncare.mapper;

import org.mapstruct.IterableMapping;

import java.util.List;

//@Mapper()
public interface MapperInterface<MDL, DTO> {

    MapperInterface INSTANCE = null;


    DTO toDto(MDL model);

    MDL toModel(DTO dto);

    @IterableMapping
    List<DTO> toDtoList(List<MDL> dtoList);

}
