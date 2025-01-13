package com.roque.teste.act.api_busca_cep.model.mapper;

import com.roque.teste.act.api_busca_cep.entity.LogEntity;
import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface  LogMapper {
    @Mapping(target = "cep", source = "cep")
    @Mapping(target = "logradouro", source = "response.logradouro")
    @Mapping(target = "bairro", source = "response.bairro")
    @Mapping(target = "localidade", source = "response.localidade")
    @Mapping(target = "uf", source = "response.uf")
    @Mapping(target = "timestamp", expression = "java(LogMapper.now())")
    LogEntity toEntity(String cep, CepResponseDto response);
    static LocalDateTime now() {
        return LocalDateTime.now();
    }
}
