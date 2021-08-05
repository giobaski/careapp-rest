package com.knits.kncare.mapper;

import org.mapstruct.IterableMapping;

import java.util.List;

//@Mapper()
public interface MapperInterface<MDL, DTO> {


    MapperInterface INSTANCE = null;


    default DTO toDto(MDL model) {
        return null;
    }

    default MDL toModel(DTO dto) {
        return null;
    }

    @IterableMapping
    default List<DTO> toDtoList(List<MDL> dtoList) {
        return null;
    }

}
