package com.roque.teste.act.api_busca_cep.service;

import com.roque.teste.act.api_busca_cep.client.BuscarCepClient;
import com.roque.teste.act.api_busca_cep.model.dto.CepResponseDto;
import com.roque.teste.act.api_busca_cep.model.entity.LogEntity;
import com.roque.teste.act.api_busca_cep.model.mapper.LogMapper;
import com.roque.teste.act.api_busca_cep.repository.LogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarCepServiceTest {

    @Mock
    private BuscarCepClient cepClient;

    @Mock
    private LogRepository logRepository;

    @Mock
    private LogMapper logMapper;

    @InjectMocks
    private BuscarCepService buscarCepService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarCep_DeveRetornarRespostaEGravarLog() {

        String cep = "01001000";

        CepResponseDto mockResponse = new CepResponseDto("01001-000", "Rua Ubacaba", "apto", "Centro", "São Paulo", "SP");
        LogEntity mockLogEntity = new LogEntity();

        when(cepClient.consultarCep(cep)).thenReturn(mockResponse);
        when(logMapper.toEntity(cep, mockResponse)).thenReturn(mockLogEntity);

       CepResponseDto result = buscarCepService.buscarCep(cep);

        assertNotNull(result);
        assertEquals(mockResponse, result);

       verify(cepClient, times(1)).consultarCep(cep);

        verify(logMapper, times(1)).toEntity(cep, mockResponse);
        verify(logRepository, times(1)).save(mockLogEntity);

        ArgumentCaptor<LogEntity> logCaptor = ArgumentCaptor.forClass(LogEntity.class);
        verify(logRepository).save(logCaptor.capture());
        assertEquals(mockLogEntity, logCaptor.getValue());
    }
}