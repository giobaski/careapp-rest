package com.knits.kncare.mapper;

import org.mapstruct.Context;
import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public interface CycleAvoidingMapperInterface<MDL, DTO> extends MapperInterface<MDL, DTO>{

    @Override
    default DTO toDto(MDL model) {
        return toDtoCyclic(model, new CycleAvoidingMappingContext());
    }

    @Override
    default MDL toModel(DTO dto) {
        return toModelCyclic(dto, new CycleAvoidingMappingContext());
    }

    @Override
    default List<DTO> toDtoList(List<MDL> modelList) {
        return toDtoList(modelList, new CycleAvoidingMappingContext());
    }

    @Named("toDtoCyclic")
    DTO toDtoCyclic(MDL model, @Context CycleAvoidingMappingContext context);

    MDL toModelCyclic(DTO model, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = {"toDtoCyclic"})
    List<DTO> toDtoList(List<MDL> dtoList, @Context CycleAvoidingMappingContext context);


}
