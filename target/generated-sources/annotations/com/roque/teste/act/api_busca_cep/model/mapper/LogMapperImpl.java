package com.roque.teste.act.api_busca_cep.model.mapper;

import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import com.roque.teste.act.api_busca_cep.model.entity.LogEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-09T19:32:13-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class LogMapperImpl implements LogMapper {

    @Override
    public LogEntity toEntity(String cep, CepResponseDto response) {
        if ( cep == null && response == null ) {
            return null;
        }

        LogEntity logEntity = new LogEntity();

        if ( response != null ) {
            logEntity.setLogradouro( response.getLogradouro() );
            logEntity.setBairro( response.getBairro() );
            logEntity.setLocalidade( response.getLocalidade() );
            logEntity.setUf( response.getUf() );
        }
        logEntity.setCep( cep );
        logEntity.setTimestamp( LogMapper.now() );

        return logEntity;
    }
}
