package com.roque.teste.act.api_busca_cep.service;

import com.roque.teste.act.api_busca_cep.client.BuscarCepClient;
import com.roque.teste.act.api_busca_cep.entity.LogEntity;
import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import com.roque.teste.act.api_busca_cep.model.mapper.LogMapper;
import com.roque.teste.act.api_busca_cep.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class BuscarCepService {
    private final BuscarCepClient cepClient;
    @Autowired
    private final LogRepository logRepository;
    private final LogMapper logMapper;

    public BuscarCepService(BuscarCepClient cepClient, LogRepository logRepository, LogMapper logMapper) {
        this.cepClient = cepClient;
        this.logRepository = logRepository;
        this.logMapper = logMapper;

    }

    public CepResponseDto buscarCep(String cep) {

        String cepPattern = "\\d{8}";

        // Verifica se o CEP está no formato correto
        if (!Pattern.matches(cepPattern, cep)) {
            // Lança uma exceção ou retorna um objeto de erro, indicando que o CEP é inválido
            throw new IllegalArgumentException("CEP inválido. Deve conter 8 dígitos numéricos.");
        }

        // Chamada à API externa
        CepResponseDto response = cepClient.consultarCep(cep);

        // Salvar log no banco
        LogEntity logEntity = logMapper.toEntity(cep, response);
        logRepository.save(logEntity);

        return response;
    }
}
