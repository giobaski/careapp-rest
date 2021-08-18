package com.knits.kncare.mapper;

import java.util.List;
import java.util.Set;

//@Mapper()
public interface MapperInterface<MDL, DTO> {

    DTO toDto(MDL model);

    MDL toModel(DTO dto);

    List<DTO> toDtoList(List<MDL> modelList);
    List<MDL> toModelList(List<DTO> dtoList);

    Set<DTO> toDtoSet(Set<MDL> modelSet);
    Set<MDL> toModelSet(Set<DTO> dtoSet);

}
