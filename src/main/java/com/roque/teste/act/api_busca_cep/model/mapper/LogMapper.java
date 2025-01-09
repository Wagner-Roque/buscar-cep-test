package com.roque.teste.act.api_busca_cep.model.mapper;

import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import com.roque.teste.act.api_busca_cep.model.entity.LogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public  class LogMapper {
    @Mapping(target = "timestamp", expression = "java(LocalDateTime.now())")
    public LogEntity toEntity(String cep, CepResponseDto response) {
        return null;
    }
}
