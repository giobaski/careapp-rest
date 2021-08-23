package com.knits.kncare.mapper;

import org.mapstruct.Context;
import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

public interface CycleAvoidingMapperInterface<MDL, DTO> extends MapperInterface<MDL, DTO> {

    @Override
    @Named("abc3")
    default DTO toDto(MDL model) {
        return toDtoCyclic(model, new CycleAvoidingMappingContext());
    }

    @Override
    @Named("abc1")
    default List<DTO> toDtoList(List<MDL> modelList) {
        return toDtoListCyclic(modelList, new CycleAvoidingMappingContext());
    }

    @Override
    @Named("abc")
    default Set<DTO> toDtoSet(Set<MDL> modelSet) {
        return toDtoSetCyclic(modelSet, new CycleAvoidingMappingContext());
    }


    @IterableMapping(qualifiedByName = {"toDtoCyclic"})
    DTO toDtoCyclic(MDL model, @Context CycleAvoidingMappingContext context);

    //    @IterableMapping(qualifiedByName = {"toDtoCyclic", "toDtoListCyclicInter", "toDtoSetCyclicInter"})
    Set<DTO> toDtoSetCyclic(Set<MDL> modelSet, @Context CycleAvoidingMappingContext context);

    //    @IterableMapping(qualifiedByName = {"toDtoCyclic", "toDtoListCyclicInter", "toDtoSetCyclicInter"})
    List<DTO> toDtoListCyclic(List<MDL> dtoList, @Context CycleAvoidingMappingContext context);
}
