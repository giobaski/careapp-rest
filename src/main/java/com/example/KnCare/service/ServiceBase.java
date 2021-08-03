package com.example.KnCare.service;

import com.example.KnCare.mapper.MapperInterface;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public abstract class ServiceBase<MDL, DTO> {

    private final MapperInterface<MDL, DTO> mapper;

    public ServiceBase(MapperInterface<MDL, DTO> mapper) {
        this.mapper = mapper;
    }

    public DTO toDto(MDL model) {
        return mapper.toDto(model);
    }

    public MDL toModel(DTO dto) {
        return mapper.toModel(dto);
    }

    public List<DTO> toDtoList(List<MDL> models) {
        return mapper.toDtoList(models);
    }

    public Optional<DTO> toDtoOptional(Optional<MDL> optional) {
        return optional.map(mapper::toDto);
    }

    public Page<DTO> toDtoPage(Page<MDL> page) {
        return page.map(mapper::toDto);
    }
}
