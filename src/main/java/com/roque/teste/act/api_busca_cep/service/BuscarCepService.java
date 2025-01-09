package com.roque.teste.act.api_busca_cep.service;

import com.roque.teste.act.api_busca_cep.client.CepClient;
import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import com.roque.teste.act.api_busca_cep.model.entity.LogEntity;
import com.roque.teste.act.api_busca_cep.model.mapper.LogMapper;
import com.roque.teste.act.api_busca_cep.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarCepService {
    private final CepClient cepClient;
    @Autowired
    private final LogRepository logRepository;
    private final LogMapper logMapper;

    public BuscarCepService(CepClient cepClient, LogRepository logRepository, LogMapper logMapper) {
        this.cepClient = cepClient;
        this.logRepository = logRepository;
        this.logMapper = logMapper;

    }

    public CepResponseDto buscarCep(String cep) {
        // Chamada à API externa
        CepResponseDto response = cepClient.consultarCep(cep);

        // Salvar log no banco
        LogEntity logEntity = logMapper.toEntity(cep, response);
        logRepository.save(logEntity);

        return response;
    }
}
