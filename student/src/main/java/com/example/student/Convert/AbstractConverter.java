package com.example.student.Convert;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<ENTITY, DTO> {

    public abstract ENTITY convertDtoToEntity(DTO dto);

    public abstract DTO convertEntityToDto(ENTITY entity);

    public List<ENTITY> convertDtosToEntities(List<DTO> dtos) {
        List<ENTITY> entities = new ArrayList<>();
        for(DTO dto : dtos) entities.add(convertDtoToEntity(dto));
        return entities;
    }

    public List<DTO> convertEntitiesToDtos(List<ENTITY> entities) {
        List<DTO> dtos = new ArrayList<>();
        for(ENTITY entity : entities) dtos.add(convertEntityToDto(entity));
        return dtos;
    }
}